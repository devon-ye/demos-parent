package com.ecas.controller;

import com.ecas.model.Login;
import com.ecas.model.PageContext;
import com.ecas.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */
@Controller
@RequestMapping("/ecas/login")
public class LoginController extends BaseController {


    @Autowired
    private LoginService loginService;

    @RequestMapping(params = "cmd=list")
    public String list(Login login, ModelMap model, HttpServletRequest request) {

        PageContext pageContext = PageContext.getContext(request, rolPerPases);
        pageContext.setPageState(true);
        List <Login> logins = loginService.list(login);
        model.put("list", logins);
        model.put("login", login);
        model.put("pageContext", pageContext);
        return "/ecas/login/list";

    }


}
