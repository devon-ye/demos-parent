package com.ecas.service.impl;

import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.impl.BaseServiceImpl;
import com.ecas.dao.IRoleDao;
import com.ecas.entiy.Role;
import com.ecas.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/12/20.
 */

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<BaseManager<Role>,Role> implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Override
    public Role getRole(String roleId) {

        return roleDao.getRoleByUserId(roleId);
    }
}
