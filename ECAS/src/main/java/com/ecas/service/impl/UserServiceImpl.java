package com.ecas.service.impl;

import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.impl.BaseServiceImpl;
import com.ecas.dao.IRoleDao;
import com.ecas.dao.IUserDao;
import com.ecas.entiy.User;
import com.ecas.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/12/20.
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<BaseManager<User>,User> implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserDao userDao;

   // @Autowired
    //private IRoleDao roleDao;*/

    public UserServiceImpl() {
        LOGGER.debug("UserServiceImpl constructure");
    }


    @Override
    public User getUserByName(String userName) {
        LOGGER.debug("getUserByName,userName:{}", userName);
        return userDao.getUserByName(userName);
    }

}
