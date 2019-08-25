package org.devon.algorithm.statistics;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;

/**
 * @author Devonmusa
 * @date 2019/8/20 22:50
 * @since
 */
public class DescriptiveStatisticsDemo {
    private static DescriptiveStatistics statistics = new DescriptiveStatistics();

    public static void main(String[] args) {
        double[] array = new double[]{1, 3, 2, 90, 3, 5, 6, 5, 2, 1};
        double[] array2 = new double[]{1, 23, 21, 90, 3, 5, 6, 5, 2, 1};
        double[] array3 = new double[]{1, 23, 21, 90, 3, 5, 12, 8, 2, 1};
        double[] array4 = new double[]{1, 23, 21, 90, 3, 5, 12, 8, 2, 1};


        Kurtosis kurtosis = new Kurtosis();


        kurtosis.increment(5);

        kurtosis.increment(5);

        kurtosis.increment(5);
        double kurr2222 = kurtosis.getResult();

        kurtosis.increment(4);
        kurtosis.increment(1);



        double kurr222 = kurtosis.getResult();




        double kur = kurtosis.evaluate(array, 0, array.length);

        kurtosis.incrementAll(array2);

        double kurr1 = kurtosis.getResult();

        kurtosis.incrementAll(array3);
        double kurr2 = kurtosis.getResult();
        kurtosis.clear();

        kurtosis.incrementAll(array4);

        double kurr3 = kurtosis.getResult();

        kurtosis.increment(10000D);
      //  Kurtosis kurtosis2 =  kurtosis.copy();
        double kurr = kurtosis.getResult();

        double kurr22222 = kurtosis.getResult();
        kurtosis.increment(-10000D);

        double kurr22 = kurtosis.getResult();

        statistics.setKurtosisImpl(kurtosis);

       double ddd = statistics.getKurtosis();

       double max = statistics.getMax();


       double mean  = statistics.getMean();

       double  min= statistics.getMin();

    }
}
