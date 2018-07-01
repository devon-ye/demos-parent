package com.circulation;

/**
 * @author devonmusa
 * @description:
 * @datetime 2018/7/2 0:02
 * @since 1.0.0
 */
public class BeforePlusAndAfterPlus {
    
    
    public  void beforPlus(){
        int num=0;
        int count=0;
        for (int i = 0; i <100 ; i++) {
            //num+=i;
            num=num+i;
            count=++count;
        }
        System.out.println("beforPlus num:"+num + ",count:"+count);
    }

    public  void afterPlus(){
        int num=0;
        int count=0;
        for (int i = 0; i <100 ; i++) {
            //num+=i;
            num=num+i;
            count=count++;
        }
        System.out.println("afterPlus num:"+num + ",count:"+count);

    }


    public static void main(String[] args) {
        BeforePlusAndAfterPlus beforePlusAndAfterPlus = new BeforePlusAndAfterPlus();
        beforePlusAndAfterPlus.beforPlus();
        beforePlusAndAfterPlus.afterPlus();
    }
}
