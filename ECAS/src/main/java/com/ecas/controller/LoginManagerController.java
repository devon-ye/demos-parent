package com.ecas.controller;

import com.ecas.base.TokenManager;
import com.ecas.constants.Constants;
import com.ecas.model.AbstractUser;
import com.ecas.model.Login;

import com.ecas.model.SessionInfo;
import com.ecas.model.User;
import com.ecas.service.IUserService;
import com.ecas.service.LoginService;

import com.ecas.util.CookieUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


/**
 * Created by lenovo on 2017/12/9.
 */
@Controller
@RequestMapping("/ecas")
public class LoginManagerController extends BaseController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private IUserService userService;

    public LoginManagerController() {
    }

    public LoginManagerController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin( Login login, String verifyCode,ModelMap modelMap) {
        String vt = CookieUtil.getCookie("VT",request);

        if(vt == null) {
            String lt = CookieUtil.getCookie("LT",request);
            if(lt == null) {
                return  "/WEB-INF/login.jsp";
            }else {
                //TODO  auto login implement
                return null;
            }

        }else {
            AbstractUser user = TokenManager.validate(vt);
            if(user != null) {
                try {
                    return   validateSuccess("",vt,response,modelMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                return "/WEB-INF/login.jsp";
            }

        }
        String userName = login.getUserName();
        String password = login.getPassword();
        if(userName!= null && userName.trim().length() > 0) {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
        //    userService.getUser(user);
            return "redirect:/WEB-INF/login.jsp";
           // return  "redirect:/index.jsp";
        }else {
            modelMap.put("errorMessage","409");
            return "/login.jsp";
        }



    }

    @RequestMapping(value = "/doLogout", params = "login" ,method = RequestMethod.POST)
    public String doLogout(Login login, HttpSession session, HttpServletRequest request) {

        login.setLoginStatu(false);
        login.setUserName("");
        login.setPassword("");

        return "ecas/login.jsp";
    }


    @RequestMapping(value = "/login1ss", method = RequestMethod.POST)
    public void selectUserByID(Login login, ModelMap model, String verifyCode, HttpSession session, HttpServletRequest request){
        loginService.selectUserByID(login.getUserId());
        System.out.println("selectUserByID");
    }

    @RequestMapping("/login1")
    public String login(Login login, ModelMap model, String verifyCode, HttpSession session, HttpServletRequest request) {
        try {

            if(null != login.getUserName() && null != login.getPassword()){//判断是否录入用户名和密码
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

//                    if(login.getDepartmentCode()==null || login.getDepartmentCode().equals("")){//判断所属部门
//
//                        Company company = companyService.find(login.getDepartmentId());//获取部门信息
//
//                        if(company !=null){//判断部门信息是否存在
//
//                            login.setDepartmentCode(company.getCode());//获取部门编号
//                        }
//                    }

                    session.setAttribute("login", login);//页面传值

                    return "redirect:/login/ecas/loginSuccess.do"; //跳转方法
                } else {
                    model.put("msg", "用户名,密码不正确或用户被禁用！");
                    return "/login";
                }
            }else{
                return "/login";
            }
        } catch (Exception e) {
            model.put("msg", e.getMessage());
            e.printStackTrace();
            return Constants.ERROR_PAGE_404;
        }
    }

    @RequestMapping(value = "/ecas/loginSuccess")
    public String loginSuccess() {

        return "backpage/base/index";
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

   private  static String  validateSuccess(String backUrl,String vt,HttpServletResponse response,ModelMap model) throws IOException {
       if(backUrl != null) {
            response.sendRedirect("");
            return  null;
       }else {
           model.put("sysList","");
           model.put("vt",vt);
           return Constants.LOGIN_PAGE;
       }

   }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
