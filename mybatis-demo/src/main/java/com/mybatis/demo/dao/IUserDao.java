package com.mybatis.demo.dao;

import com.mybatis.demo.pojo.User;

/**
 * Created by lenovo on 2017/12/13.
 */
public interface IUserDao {
    User getUserById(String userId);

}
