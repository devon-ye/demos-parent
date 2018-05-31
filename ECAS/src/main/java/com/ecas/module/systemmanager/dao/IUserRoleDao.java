package com.ecas.module.systemmanager.dao;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.module.systemmanager.entiy.UserRole;
import org.apache.ibatis.annotations.Param;

public interface IUserRoleDao extends BaseDao<UserRole>{

     String getRoleIdByUserId(@Param("userId") String userId);
}
