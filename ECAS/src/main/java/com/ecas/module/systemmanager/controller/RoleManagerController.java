package com.ecas.module.systemmanager.controller;

import com.ecas.module.systemmanager.entiy.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
@Controller
@RequestMapping(value = "/role")
public class RoleManagerController extends AbstractBaseController {

    @RequestMapping(value = "/getRolesByUserId", method= RequestMethod.GET)
    public List<Role> getRolesByUserId(String userId){
        List<Role> roles = new ArrayList <>();
        Role role = new Role();
        role.setRoleName("系统管理员");
        roles.add(role);
        return roles;
    }
}
