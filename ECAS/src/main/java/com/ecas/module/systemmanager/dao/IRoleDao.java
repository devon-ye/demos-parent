package com.ecas.module.systemmanager.dao;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.module.systemmanager.entiy.Role;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IRoleDao extends BaseDao<Role> {

   public Role getRoleByUserId(String userId);
}
