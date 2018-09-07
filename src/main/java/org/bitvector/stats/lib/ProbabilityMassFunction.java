package org.bitvector.stats.lib;

import java.util.Map;

public class ProbabilityMassFunction {
    private Map<Double, Double> pmf = null;

    public ProbabilityMassFunction(Map<Double, Double> pmf) {
        if (pmf.values().stream().mapToDouble(Double::doubleValue).sum() == 1.0) {
            this.pmf = pmf;
        } else {
            throw new IllegalArgumentException("The sum of all probabilities must equal 1.0");
        }
    }
}
