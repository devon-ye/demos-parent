package com.ecas.service.impl;

import com.ecas.dao.IRoleDao;
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
    private IRoleDao roleDao;
    public UserServiceImpl() {
    }

    @Override
    public String getUser(User user) {

        User  user1 = userDao.getUser(user);
       // roleDao.
        return  "/pages/background/index.jsp";
    }
}
