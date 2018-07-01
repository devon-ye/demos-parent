package com.ecas.module.systemmanager.service.impl;

import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.impl.BaseServiceImpl;
import com.ecas.module.systemmanager.entiy.User;
import com.ecas.module.systemmanager.service.IUserService;
import com.ecas.module.systemmanager.dao.IUserDao;
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
        return null;
    }

}
