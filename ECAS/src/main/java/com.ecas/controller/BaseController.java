package com.ecas.controller;

import com.ecas.model.Login;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */
@Controller
public abstract class BaseController {

    protected int rolPerPases = 10;
    protected List colRols;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected Login login;
    protected String sysDeptCode;


    protected int getRolPerPases() {
        return rolPerPases;
    }

    protected void setRolPerPases(int rolPerPases) {
        this.rolPerPases = rolPerPases;
    }

    protected List getColRols() {
        return colRols;
    }

    protected void setColRols(List colRols) {
        this.colRols = colRols;
    }

    protected HttpServletRequest getRequest() {
        return request;
    }

    protected void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    protected HttpServletResponse getResponse() {
        return response;
    }

    protected void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    protected HttpSession getSession() {
        return session;
    }

    protected void setSession(HttpSession session) {
        this.session = session;
    }

    protected Login getLogin() {
        return login;
    }

    protected void setLogin(Login login) {
        this.login = login;
    }

    protected String getSysDeptCode() {
        return sysDeptCode;
    }

    protected void setSysDeptCode(String sysDeptCode) {
        this.sysDeptCode = sysDeptCode;
    }
}
