package org.devon.basic.demo;


public class DataTypeDemo {


    public void testChar() {
        //char 0~65536 character


        for (int i = 0; i < 655; i++) {
            char ch = (char) i;
            if (i / 50 == 0) {
                System.out.println();
            }
            System.out.print(ch + "\t");
        }
    }

    public void test() {

        // short s1 = 1;
        // s1 = (short) (s1 + 1);
        // short s2 = 1;
        // s2 += 1;
        // System.out.println(s1 + s2);
        int k = 0;
        int ret = ++k + k++ + ++k + k;
        System.out.println("k=" + k);
        System.out.println("ret=" + ret);
        //Integer ints=new Integer(30);

    }

}
