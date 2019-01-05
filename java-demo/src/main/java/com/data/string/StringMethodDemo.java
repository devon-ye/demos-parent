package com.data.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2017/11/21.
 */
public class StringMethodDemo {

    public static String stringFilter(String str)  {
        // 只允许字母和数字
        // String    regEx   =   "[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？《》]";
        Pattern p    =    Pattern.compile(regEx);
        Matcher m    =    p.matcher(str);
        String str1= "aaaebbbcccddd";


        return    m.replaceAll("").trim();
    }

    public static String StringFilter2(String  str2){
       String str3 = str2.replaceAll("(?s)(\\-)(?=.*\\1)", "$1");
        System.out.printf("str3:"+str3.toString());


        return str2;
    }

    public static void main(String[] args) {
        StringMethodDemo.StringFilter2("84234-23qweqw424-234-23423");
        String aa= "84234-233qweqw424-234-23423";
        String aas = aa.replaceAll("(.)\\1+", "$1");
        System.out.printf("\naaa="+aas);
    }
}
