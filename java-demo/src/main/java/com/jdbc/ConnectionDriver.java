package com.jdbc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2017/10/13.
 */
public class ConnectionDriver {

    static class  ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if("commit".equals(method.getName())){
                TimeUnit.MICROSECONDS.sleep(100);
            }
                return null;
        }
    }

    public static final Connection createConnection() {
        Connection connection = (Connection)Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),new Class<?>[]{Connection.class},new ConnectionHandler());

        return connection;
    }
}
