package com.concurrency.thread.unsafe;

/**
 * Created by lenovo on 2017/10/8.
 */
public class LoginServlet {
    private static String userNameRes;
    private static String passwordRes;

    public static void doPost(String userName,String password) {
        try {


            userNameRes = userName;
            if(userName.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRes = password;

            System.out.println("userName" + userNameRes +", password" + passwordRes);

        }catch (Exception e) {

        }

    }


}
