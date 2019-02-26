package org.devon.parallel.knnclassifier;

import com.sun.xml.internal.bind.v2.util.EditDistance;

import java.awt.image.SampleModel;
import java.util.Arrays;
import java.util.List;

/**
 * @author dewen.ye
 * @date 2019/2/26 23:26
 */
public class KnnClassifier {

    private final List<? extends Sample> dataSet;
    private int k;

    public KnnClassifier(List<? extends Sample> dataSet, int k) {
        this.dataSet = dataSet;
        this.k = k;
    }

    public String classify(Sample example){
       Distance[] distances = new Distance[dataSet.size()];
       int index = 0;
        for (Sample localSample : dataSet) {
            distances[index] = new Distance();
            distances[index].setIndex(index);
            distances[index].setCalculator(EuclideanDistanceCalculator.calculate(localSample,example));
          index++;
        }
        Arrays.sort(distances);
      return "";
    }

    class Sample{
        double[] example;

        public double[] getExample() {
            return example;
        }

        public void setExample(double[] example) {
            this.example = example;
        }
    }

   protected class Distance{
        private int index;
        private double  calculator;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

       public double getCalculator() {
           return calculator;
       }

       public void setCalculator(double calculator) {
           this.calculator = calculator;
       }
   }
};
