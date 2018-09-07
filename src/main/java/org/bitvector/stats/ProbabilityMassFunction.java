package org.bitvector.stats;

import java.util.Map;

class ProbabilityMassFunction {

    private Map<Double, Double> mappings;

    ProbabilityMassFunction(Map<Double, Double> pmf) {
        if (pmf.values().stream().mapToDouble(Double::doubleValue).sum() == 1.0) {
            this.mappings = pmf;
        } else {
            throw new IllegalArgumentException("The sum of all probabilities must equal 1.0");
        }
    }

    Map<Double, Double> getMappings() {
        return mappings;
    }

}
