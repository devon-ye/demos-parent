package org.devon.java7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */
public class TryCatchFinally {
    private static final Logger LOG = LoggerFactory.getLogger(TryCatchFinally.class);
    private String id;
    private String name;

    static {
        LOG.info("this class method static{  }!");
    }

    public TryCatchFinally() {
        LOG.info("this construct method, String");
    }

    public TryCatchFinally(String str) {
        LOG.info("this construct method, String arg=" + str);
    }

    public int returnStep() {

        try {
            LOG.info("try executing....");
            return 1;

        } catch (Exception e) {
            LOG.info("catch executing....");
            return 2;
        } finally {
            LOG.info("finally executing....");
            //bug return
            //  return 3;
        }

    }

    public TryCatchFinally returnTryCatchFinally() {
        try {
            System.out.println("try executing....");
            List<String> lsit = null;
           for(String str:lsit){
               LOG.info("str:{}",str);
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

        LOG.info(" retunrn Int = " + returnIn);

        TryCatchFinally returnTryCatchFinally = tryCatchFinally.returnTryCatchFinally();
        LOG.info(" return tryCatchFinally = " + returnTryCatchFinally);

    }
}
