package org.devon.parallel.knnclassifier;

/**
 * @author dewen.ye
 * @date 2019/2/26 23:46
 */
public class EuclideanDistanceCalculator {

    public  static double calculate(KnnClassifier.Sample  example1, KnnClassifier.Sample example2){
        double ret = 0.0D;
        double[] data1 = example1.getExample();
        double[] data2 = example2.getExample();

        if(data1.length != data2.length){
            throw new IllegalArgumentException();
        }

        for (int i = 0; i <data1.length ; i++) {
            ret+= Math.pow(data1[i]-data2[i],2);
        }
        return Math.sqrt(ret);

    }

}
