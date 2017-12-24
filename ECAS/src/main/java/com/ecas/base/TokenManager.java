package com.ecas.base;

import com.ecas.model.AbstractUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by lenovo on 2017/12/24.
 * @author  devon
 */
public class TokenManager {
    private static Logger logger = LoggerFactory.getLogger(TokenManager.class);

    private static final Timer timer = new Timer(true);
    private static final Map<String,Token> VT_TOLEN_MAP = new ConcurrentHashMap<>();

    static {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Map.Entry<String,Token> entry:VT_TOLEN_MAP.entrySet()) {
                    String vt = entry.getKey();
                    Token token = entry.getValue();
                    Date expired = token.expired;
                    Date currentTime = new Date();
                    if(currentTime.compareTo(expired)>0) {

                    }else{

                    }
                }
            }
        },30);
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
