package com.ecas.service.impl;

import com.alibaba.druid.support.logging.JakartaCommonsLoggingImpl;
import com.ecas.dao.IRoleDao;
import com.ecas.model.Role;
import com.ecas.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2017/12/20.
 */

public class RoleServiceImpl extends ServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Override
    public Role getRole(String roleId) {

        return roleDao.getRoleByUserId(roleId);
    }
}
