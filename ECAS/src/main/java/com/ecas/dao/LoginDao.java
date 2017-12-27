package com.ecas.dao;

import com.ecas.model.Login;

/**
 * Created by lenovo on 2017/12/14.
 */
public interface LoginDao  extends  IDao{

    Login selectUserByID(long loginId);
}
