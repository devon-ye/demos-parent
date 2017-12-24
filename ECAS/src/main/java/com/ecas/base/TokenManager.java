package com.ecas.base;

import com.ecas.model.AbstractUser;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lenovo on 2017/12/24.
 * @author  devon
 */
public class TokenManager {

    private static final Map<String,Token> VT_TOLEN_MAP = new ConcurrentHashMap<>();

    static {

    }

    private  TokenManager(){};

    private static class Token{
        private AbstractUser abstractUser;
        private Date expired;
    }
    public static AbstractUser validate(String vt){
        Token token = VT_TOLEN_MAP.get(vt);
        return token==null? null: token.abstractUser;
    }

    public static void addToken(String vt,AbstractUser abstractUser) {
        Token token = new Token();
        token.abstractUser=abstractUser;
        token.expired= new Date(System.currentTimeMillis() + 60 * 1000);
        VT_TOLEN_MAP.put(vt,token);
    }
}
