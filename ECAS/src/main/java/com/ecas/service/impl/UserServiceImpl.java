package com.ecas.service.impl;

import com.ecas.dao.IUserDao;
import com.ecas.model.User;
import com.ecas.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/12/20.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    public UserServiceImpl() {
    }

    @Override
    public String getUser(User user) {
        userDao.getUser(user);
        return  "/pages/background/index.jsp";
    }
}
