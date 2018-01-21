package com.ecas.dao;

import org.apache.ibatis.annotations.Param;

public interface IUserRoleDao {

    public String getRoleIdByUserId(@Param("userId") String userId);
}
