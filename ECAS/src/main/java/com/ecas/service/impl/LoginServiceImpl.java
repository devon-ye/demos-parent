package com.ecas.service.impl;

import com.ecas.dao.LoginDao;
import com.ecas.model.Login;
import com.ecas.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lenovo on 2017/12/9.
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private LoginDao loginDao;


    public LoginServiceImpl() {
    }

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }


    @Override
    public void init() {

    }


    @Override
    public Login selectUserByID(long loginId) {
        return loginDao.selectUserByID(loginId);
    }



   /* @Override
    public Login login(Login login) {
        return loginDao.selectUserByID(login.getUserId());
    }*/

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
