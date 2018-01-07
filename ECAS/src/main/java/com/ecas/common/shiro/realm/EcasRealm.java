package com.ecas.common.shiro.realm;

import com.ecas.util.PropertiesFileUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lenovo on 2017/12/28.
 */
public class EcasRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LoggerFactory.getLogger(EcasRealm.class);

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
        LOGGER.debug("doGetAuthenticationInfo,authenticationToken:{}",authenticationToken);
        String upmsType = PropertiesFileUtil.getInstance("shiro").get("ecas.type");
        if ("client".equals(upmsType)) {
            return new SimpleAuthenticationInfo(username, password, getName());
        }

        return new SimpleAuthenticationInfo(username,password,getName());

    }
}
