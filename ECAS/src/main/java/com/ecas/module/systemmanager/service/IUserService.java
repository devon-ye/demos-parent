package com.ecas.module.systemmanager.service;


import com.ecas.common.base.service.BaseService;
import com.ecas.module.systemmanager.entiy.User;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IUserService extends BaseService<User>{

      User getUserByName(String userName);
}
