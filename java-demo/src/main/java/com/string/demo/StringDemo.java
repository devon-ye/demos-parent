package com.string.demo;


public class StringDemo {
    public static final long COUNT = 2000000000;
    // 要测试的程序或方法

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // 获取开始时间
        String s[] = {"charry", "ive", "amy"};
        String str= "";
        if(str.trim().length()==0){
            System.out.println("空串");
        }


      //  int i = s.length;

      // String str =  s.toString();


    //    s[0].toString();
        String temp = s[0]; // 字符串数组有lenth属性，而字符串有lenth()方法
        temp.length();
        long end = System.currentTimeMillis(); // 获取结束时间

        System.out.println("程序运行时间： " + (end - start) + "ms");

    }

    @SuppressWarnings("unused")
    public static void newString() {
        long start = System.currentTimeMillis(); // 获取开始时间
        for (int i = 0; i < COUNT; i++) {
            String str = new String("hello");

        }
        long end = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间： " + (end - start) + "ms");
    }

    @SuppressWarnings("unused")
    public static void valueString() {

        long start = System.currentTimeMillis(); // 获取开始时间
        for (int i = 0; i < COUNT; i++) {
            String str1 = "hello";
            char[] ch = str1.toCharArray();
            String str = String.valueOf(ch[0]);

        }
        long end = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间： " + (end - start) + "ms");
    }


}
