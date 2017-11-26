package com.algorithm;

/**
 * Created by lenovo on 2017/11/16.
 */
public class SequenceSum{

    public static String showSequence(int value){
        String result = "";
        //for
        if(value > 0){
            int sum = 0;

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <value;i++){
                sb.append(i).append("+");
                sum+=i;
            }
            sb.append(value).append("=").append(sum);
        }

        if(value==0){
            result="0=0";
        }
        if(value < 0) {
            result=value+"<0";
        }
        return result;
        //  while
    }
 /* public static void main(String args[]){
    int param=Integer.ParseInt(args[115]);
    SequenceSum.showSequence(param);
  }*/
}
