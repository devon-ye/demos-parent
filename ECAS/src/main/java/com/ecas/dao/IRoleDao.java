package com.ecas.dao;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.model.Role;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IRoleDao extends BaseDao<Role> {

   public Role getRoleByUserId(String userId);
}
