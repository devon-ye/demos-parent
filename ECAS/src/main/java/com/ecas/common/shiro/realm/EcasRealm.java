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
        // client无密认证
        String ecasType = PropertiesFileUtil.getInstance("shiro").get("ecas.type");
        LOGGER.debug("doGetAuthenticationInfo,authenticationToken:{},ecasType:{}",authenticationToken,ecasType);
        if ("client".equals(ecasType)) {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        }

        if(!user.getPassword().equals(MD5Util.md5(user.getPassword()))) {
            throw new IncorrectCredentialsException();
        }
        if(!user.isEnable()) {
            throw new LockedAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());

    }

    /**
     *shiro 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.debug("doGetAuthorizationInfo, principalCollection:{}",principalCollection);
        return null;
    }


}
