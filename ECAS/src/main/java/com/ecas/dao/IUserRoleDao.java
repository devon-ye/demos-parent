package com.ecas.dao;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.model.UserRole;
import org.apache.ibatis.annotations.Param;

public interface IUserRoleDao extends BaseDao<UserRole>{

     String getRoleIdByUserId(@Param("userId") String userId);
}
