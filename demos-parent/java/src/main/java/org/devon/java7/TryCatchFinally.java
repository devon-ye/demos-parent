package org.devon.java7;

import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */
public class TryCatchFinally {
    private String id;
    private String name;

    static {
        System.out.println("this class method static{  }!");
    }

    public TryCatchFinally() {
        System.out.println("this construct method, String");
    }

    public TryCatchFinally(String str) {
        System.out.println("this construct method, String arg=" + str);
    }

    public int returnStep() {

        try {
            System.out.println("try executing....");
            return 1;

        } catch (Exception e) {
            System.out.println("catch executing....");
            return 2;
        } finally {
            System.out.println("finally executing....");
            //bug return
            //  return 3;
        }

    }

    public TryCatchFinally returnTryCatchFinally() {
        try {
            System.out.println("try executing....");
            List<String> lsit = null;
           for(String str:lsit){

           }

            return new TryCatchFinally("try return");

        } catch (Exception e) {
            System.out.println("catch executing....");
            return new TryCatchFinally("catch return");
        } finally {
            System.out.println("finally executing....");
            //bug return
            // return new TryCatchFinally("finally return");
        }

    }



    public static void main(String[] args) {
        TryCatchFinally tryCatchFinally = new TryCatchFinally();
        int returnIn = tryCatchFinally.returnStep();

        System.out.println(" retunrn Int = " + returnIn);

        TryCatchFinally returnTryCatchFinally = tryCatchFinally.returnTryCatchFinally();
        System.out.println(" return tryCatchFinally = " + returnTryCatchFinally);

    }
}
