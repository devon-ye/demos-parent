package com.ecas.service;

import com.ecas.model.Role;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface IRoleService extends IService {

    Role getRole(String userId);
}
