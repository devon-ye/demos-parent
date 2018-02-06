package com.ecas.service;


import com.ecas.common.base.service.BaseService;
import com.ecas.entiy.User;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IUserService extends BaseService<User>{

      User getUserByName(String userName);
}
