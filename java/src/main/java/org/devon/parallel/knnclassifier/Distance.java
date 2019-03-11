package org.devon.parallel.knnclassifier;

/**
 * @author dewen.ye
 * @date 2019/3/10 09:05
 */
public class Distance implements Comparable<Distance> {
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

    @Override
    public int compareTo(Distance o) {
        return this.compareTo(o);

    }
}
