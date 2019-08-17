package org.devon.parallel.knnclassifier;


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



};
