package com.ecas.service.impl;

import com.ecas.dao.IUserRoleDao;
import com.ecas.service.IUserRoleService;
import com.ecas.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userRoleService")
public class UserRoleServiceImpl extends ServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public long getRoleIdByUserId(long userId) {
        return userRoleDao.getRoleIdByUserId(userId);
    }
}
