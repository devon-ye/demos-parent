package com.circulation;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/10.
 */
public class ForCirrulationExecuteStep {

    public static void forExecuteStep () {
        int i=0;
        for(printStep("A");printStep("B")&& i< 4; printStep("C")) {
            printStep("D");
            i++;
        }
    }



    public static boolean  printStep(String str) {
        System.out.println("current execute step :" + str);
        return true;
    }

    public static void main(String[] args) {
        forExecuteStep();

    }
}
