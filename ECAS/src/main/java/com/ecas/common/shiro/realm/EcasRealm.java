package com.ecas.common.shiro.realm;

import com.ecas.entiy.User;
import com.ecas.service.IRoleService;
import com.ecas.service.IUserRoleService;
import com.ecas.service.IUserService;
import com.ecas.util.*;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2017/12/28.
 */
public class EcasRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(EcasRealm.class);

    @Autowired
    private  IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

//    @Autowired
//    private CaptchaCacheService captchaCacheService;
//
//    @Autowired
//    private DefaultPasswordService defaultPasswordService;



    /**
     * Shiro登录认证(原理：用户提交 用户名和密码 --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回 ----
     * shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LOGGER.debug("doGetAuthenticationInfo, UsernamePasswordToken:{}",token);
        User user = (User) userService.getUserByName(token.getUsername());
        if(user == null) {
            LOGGER.error("current login user not exist!");
            throw new UnknownAccountException();
        }
        if(user.getActiveStatus() == 0) {
            LOGGER.error("current login user is disabled!");
           throw new DisabledAccountException();
        }

        if(user.getActiveStatus() == 2) {
            LOGGER.error("current login user is Locked!");
            throw new LockedAccountException();
        }

        LOGGER.debug("password:"+token.getCredentials());
        LOGGER.debug("token password:" + token.getPassword().toString());
        LOGGER.debug("database password:" +user.getPassword());
        LOGGER.debug("decode password:"+AESUtil.aesDecode(user.getPassword()));

     //   defaultPasswordService.encryptPassword(token.getPassword());

        if(token.getPassword().equals(AESUtil.aesDecode(user.getPassword()))) {
            LOGGER.error("current login user password incorrect!");
            throw new IncorrectCredentialsException();
        }

         /*String roleId = userRoleService.getRoleIdByUserId(user.getUserId());
         if(roleId == null) {
             LOGGER.error("current login user is disabled!");
             throw new DisabledAccountException();
         }*/
         /*Role role = roleService.getRole(roleId);
         if(role == null) {
             LOGGER.error("current login user is disabled!");
             throw new DisabledAccountException();
         }*/
         // client无密认证
//        String ecasType = PropertiesFileUtil.getInstance("shiro").get("ecas.type");
//        if ("client".equals(ecasType)) {
//            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
//        }

        return new SimpleAuthenticationInfo(user.getUserName(), token.getPassword(), getName());

    }

    /**
     *shiro 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.debug("doGetAuthorizationInfo, principalCollection:{}",principalCollection);
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = (User) userService.getUserByName(userName);
        String roleId = userRoleService.getRoleIdByUserId(user.getUserId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //TODO
      //  simpleAuthorizationInfo.setRoles();
      //  simpleAuthorizationInfo.setStringPermissions();
        return simpleAuthorizationInfo;
    }


}
