package com.string.demo;

/**
 * Created by lenovo on 2017/11/11.
 */
public class StringChange {


    public static void changeStr(String str) {
        str = "welcome";
    }

    public static void main(String[] args) {
        String str = "1234";
        changeStr(str);
        System.out.println(str);
    }

}
