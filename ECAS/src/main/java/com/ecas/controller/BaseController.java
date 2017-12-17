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

    public int rolPerPases = 10;
    public List colRols;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;
    public Login login;
    public String sysDeptCode;


    public int getRolPerPases() {
        return rolPerPases;
    }

    public void setRolPerPases(int rolPerPases) {
        this.rolPerPases = rolPerPases;
    }

    public List getColRols() {
        return colRols;
    }

    public void setColRols(List colRols) {
        this.colRols = colRols;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getSysDeptCode() {
        return sysDeptCode;
    }

    public void setSysDeptCode(String sysDeptCode) {
        this.sysDeptCode = sysDeptCode;
    }
}
