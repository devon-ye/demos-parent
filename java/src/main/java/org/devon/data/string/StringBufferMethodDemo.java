package org.devon.data.string;

import java.lang.*;

/**
 * Created by lenovo on 2017/11/21.
 */
public class StringBufferMethodDemo {
    private StringBuffer sb;

    public StringBufferMethodDemo(){
        sb = new StringBuffer();
    }

    public  void recovere(){
        sb.append("字符串");
        System.out.println(sb);

        String str =sb.reverse().toString();
        System.out.println(sb);
        if(sb.toString().equals(str)){
            System.out.println(" this is equals");
        }

        //sb.appendCodePoint();

    }

    public static void main(String[] args) {
        StringBufferMethodDemo sbmd = new StringBufferMethodDemo();
        sbmd.recovere();
    }
}
