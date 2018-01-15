package com.ecas.common.shiro.realm;

import com.ecas.model.User;
import com.ecas.service.IUserService;
import com.ecas.service.impl.UserServiceImpl;
import com.ecas.util.MD5Util;
import com.ecas.util.PropertiesFileUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.debug("doGetAuthorizationInfo, principalCollection:{}",principalCollection);
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // client无密认证
        String ecasType = PropertiesFileUtil.getInstance("shiro").get("ecas.type");
        LOGGER.debug("doGetAuthenticationInfo,authenticationToken:{},ecasType:{}",authenticationToken,ecasType);
        if ("client".equals(ecasType)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }
        User user = userService.getUserByName(username);
        if(user == null) {
            throw new UnknownAccountException();
        }
        if(!user.getPassword().equals(MD5Util.md5(password))) {
            throw new IncorrectCredentialsException();
        }
        if(!user.isEnable()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(username,password,getName());

    }
}
