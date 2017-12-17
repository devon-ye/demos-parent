package com.ecas.service;

import com.ecas.model.Login;


/**
 * Created by lenovo on 2017/12/9.
 */
public interface LoginService {

    Login selectUserByID(long loginId);

    void init();

}
