package org.bitvector.stats;

import java.util.Map;

class ProbabilityMassFunction implements Statistics {

    private Map<Double, Double> pmf;
    private Map<Double, Double> lrRatio;

    ProbabilityMassFunction(Map<Double, Double> pmf) {
        if (pmf.values().stream().mapToDouble(Double::doubleValue).sum() == 1.0) {
            this.pmf = pmf;
            initLRratio();
        } else {
            throw new IllegalArgumentException("The sum of all probabilities must equal 1.0");
        }
    }

    private void initLRratio() {
        // FIXME
    }

    private Double massMidpoint() {
        return 0.0; // FIXME
    }

    private Double maxP() {
        return 0.0; // FIXME
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
