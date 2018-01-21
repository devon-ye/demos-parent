package com.ecas.dao;

import com.ecas.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lenovo on 2017/12/20.
 */

public interface IUserDao extends  IDao{

    public User  getUserById(String userId);

    public User getUserByName(@Param("userName") String userName);
}
