package com.ecas.dao;

import com.ecas.model.Role;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IRoleDao extends  IDao {

   public Role getRoleByUserId(String userId);
}
