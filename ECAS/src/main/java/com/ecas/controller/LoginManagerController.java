package com.ecas.controller;

import com.ecas.common.constants.Constants;
import com.ecas.common.shiro.session.EcasSession;
import com.ecas.common.shiro.session.EcasSessiondDao;
import com.ecas.model.Login;
import com.ecas.model.SessionInfo;
import com.ecas.model.User;
import com.ecas.service.IUserService;
import com.ecas.service.LoginService;
import com.ecas.util.CookieUtil;
import com.ecas.util.RedisUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;


/**
 * Created by lenovo on 2017/12/9.
 */
@Controller
@RequestMapping("/ecas")
public class LoginManagerController extends AbstractBaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginManagerController.class);


    @Autowired
    private IUserService userService;
    @Autowired
    private EcasSessiondDao ecasSessiondDao;

    public LoginManagerController() {
        LOGGER.debug("LoginManagerController() constructure.");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String verifyCode, ModelMap modelMap, HttpServletRequest request) {
        LOGGER.debug("login, verifyCode:{},modelMap:{},request:{}", verifyCode, modelMap, request);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        String serverSessionId = session.getId().toString();
        if (verifyCode == null) {
            //TODO 验证码校验
        }
        String backUrl = request.getParameter("backUrl");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");


        if (userName == null && userName.trim().length() <= 0) {
            modelMap.put("errorMessage", "409");
            return "/login.jsp";
        }
        String sessionIdStr = RedisUtil.get(Constants.SHIRO_SESSION_ID + "_" + serverSessionId);
        if (sessionIdStr == null || serverSessionId.length() == 0) {

            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password, request.getRemoteHost());
            if (BooleanUtils.toBoolean(rememberMe)) {
                usernamePasswordToken.setRememberMe(true);
            } else {
                usernamePasswordToken.setRememberMe(false);
            }
            try {
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                LOGGER.error("帐号不存在！");
            } catch (IncorrectCredentialsException e) {
                LOGGER.error("密码错误！");
            } catch (LockedAccountException e) {
                LOGGER.error("帐号已锁定！");
            }

            ecasSessiondDao.updateStatus(sessionIdStr,EcasSession.OnlineStatus.on_line);

            RedisUtil.lpush(Constants.SHIRO_SESSION_ID, sessionIdStr.toString());
            String uuid = UUID.randomUUID().toString();
            //TODO
            LOGGER.debug("login, usernamePasswordToken:{}", usernamePasswordToken);
        }

        return "redirect:/pages/background/main.jsp";

    }

    @RequestMapping(value = "/doLogout", method = RequestMethod.POST)
    public String doLogout(Login login, HttpSession session, HttpServletRequest request) {

        login.setLoginStatu(false);
        login.setUserName("");
        login.setPassword("");

        return "ecas/login.jsp";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Login login, ModelMap model, String verifyCode, HttpSession session, HttpServletRequest request) {
        LOGGER.debug("login, login:{},modelMap:{},verifyCode:{},session:{},request:{}", login, model, verifyCode, session, request);
        try {
            if (null != login.getUserName() && null != login.getPassword()) {//判断是否录入用户名和密码
                login.setPassword(login.getPassword());
                // login = iLoginService.login(login);//获取用户信息
                if (null != login) {//获取用户信息成功
                    login.setLoginTime(new Date());//更新当前登录时间
                    login.setLoginIp(request.getRemoteHost());//获取登录IP地址
                    login.setLoginStatu(true);//获取登录状态
                    //  iLoginService.update(login);//更新登录信息
                    SessionInfo sessionInfo = new SessionInfo();//创建session信息模型
                    /*sessionInfo.setLogin(login);//赋值登录信息
                    sessionInfo.setResourceMap(loginService.resourceList(login.getRoleId()));//获取用户权限菜单*/
                    session.setAttribute("sessionInfoName", sessionInfo);
                    session.setAttribute("login", login);//页面传值

                    return "redirect:/login/ecas/loginSuccess.do"; //跳转方法
                } else {
                    model.put("msg", "用户名,密码不正确或用户被禁用！");
                    return "/login";
                }
            } else {
                return "/login";
            }
        } catch (Exception e) {
            model.put("msg", e.getMessage());
            e.printStackTrace();
            return Constants.ERROR_PAGE_404;
        }
    }

    @RequestMapping(value = "/login1ss", method = RequestMethod.POST)
    public void selectUserByID(Login login, ModelMap model, String verifyCode, HttpSession session, HttpServletRequest request) {
        // loginService.selectUserByID(login.getUserId());
        System.out.println("selectUserByID");
    }




   /* public String list(Login login, ModelMap model, HttpServletRequest request) {

        PageContext pageContext = PageContext.getContext(request, rolPerPases);
        pageContext.setPageState(true);
        List <Login> logins = iLoginService.list(login);
        model.put("list", logins);
        model.put("login", login);
        model.put("pageContext", pageContext);
        return "/ecas/login/list";

    }*/

    private static String validateSuccess(String backUrl, String vt, HttpServletResponse response, ModelMap model) throws IOException {
        if (backUrl != null) {
            response.sendRedirect("");
            return null;
        } else {
            model.put("sysList", "");
            model.put("vt", vt);
            return Constants.LOGIN_PAGE;
        }

    }


}
