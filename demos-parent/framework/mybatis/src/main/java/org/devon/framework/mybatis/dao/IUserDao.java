package org.devon.framework.mybatis.dao;

import org.devon.framework.mybatis.pojo.User;

/**
 * Created by lenovo on 2017/12/13.
 */
public interface IUserDao {
    User getUserById(String userId);

}
