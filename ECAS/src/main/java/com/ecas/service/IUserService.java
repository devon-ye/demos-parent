package com.ecas.service;

import com.ecas.model.User;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IUserService<User>{

     public User getUserByName(String userName);
}
