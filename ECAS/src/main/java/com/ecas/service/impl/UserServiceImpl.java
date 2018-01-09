package com.ecas.service.impl;

import com.ecas.dao.IRoleDao;
import com.ecas.dao.IUserDao;
import com.ecas.model.User;
import com.ecas.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/12/20.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;
    private IRoleDao roleDao;
    public UserServiceImpl() {
        LOGGER.debug("UserServiceImpl constructure");
    }


    @Override
    public User getUserById(String userId) {
        LOGGER.debug("getUserById,userId:{}",userId);

        return null;
    }

    @Override
    public User getUserByName(String userName) {
        LOGGER.debug("getUserByName,userName:{}",userName);
        return null;
    }
}
