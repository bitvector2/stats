package org.bitvector.stats;

import java.util.SortedMap;
import java.util.TreeMap;

class ProbabilityMassFunction implements Statistics {

    private TreeMap<Double, Double> pmf;
    private TreeMap<Double, Double> lrRatios;

    ProbabilityMassFunction(TreeMap<Double, Double> pmf) {
        if (pmf.values().stream().mapToDouble(Double::doubleValue).sum() == 1.0) {
            this.pmf = pmf;
            initLRratio();
        } else {
            throw new IllegalArgumentException("The sum of all probabilities must equal 1.0");
        }
    }

    private void initLRratio() {
        for (Double i : pmf.keySet()) {
            SortedMap<Double, Double> leftMap = pmf.headMap(i, true);
            SortedMap<Double, Double> rightMap = pmf.tailMap(i, true);

            Double leftPsum = leftMap.values().stream().mapToDouble(Double::doubleValue).sum();
            Double rightPsum = rightMap.values().stream().mapToDouble(Double::doubleValue).sum();
            Double lrRatio = leftPsum / rightPsum;

            // FIXME System.out.println("Key: " + i + " Value: " + lrRatio);
        }
    }

    public Double mean() {
        return 0.0; // FIXME
    }

    public Double median() {
        return 0.0; // FIXME
    }

    public Integer mode() {
        return 0; // FIXME
    }

    public Double variance() {
        return 0.0; // FIXME
    }

    public Double stdDeviation() {
        return 0.0; // FIXME
    }

    public Double coefOfVariance() {
        return 0.0; // FIXME
    }

}
