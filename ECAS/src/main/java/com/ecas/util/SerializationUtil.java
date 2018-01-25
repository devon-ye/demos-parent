package com.ecas.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;


public class SerializationUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SerializationUtil.class);

    public static String serilaze(Session session) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(session);
        } catch (IOException e) {
            LOGGER.error("serilaze, session:{}", session);
            // throw new Exception("serilaze, session");
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray());
    }

    public static Session deSerilaze(String sessionStr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(sessionStr));
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Session) objectInputStream.readObject();
        } catch (IOException e) {
            LOGGER.error("serilaze, sessionStr:{},Exception:{}", sessionStr, e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("serilaze, sessionStr:{},Exception:{}", sessionStr, e);

        }
        return null;
    }
}
