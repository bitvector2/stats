package org.bitvector.stats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class IntegerVector implements Statistics {

    private ArrayList<Integer> vector;

    IntegerVector(ArrayList<Integer> vector) {
        this.vector = vector;
    }

    public Double mean() {
        // https://en.wikipedia.org/wiki/Mean#Arithmetic_mean_(AM)

        double tally = vector.stream().mapToInt(Integer::intValue).sum();
        return tally / vector.size();
    }

    public Double median() {
        // https://en.wikipedia.org/wiki/Median

        Collections.sort(vector);
        double median;

        if (vector.size() % 2 == 0) {   // case of even size vector
            int overMidpoint = vector.size() / 2;
            int underMidpoint = overMidpoint - 1;
            median = (vector.get(underMidpoint) + vector.get(overMidpoint)) / 2.0;

        } else {                        // case of odd size vector
            int midpoint = vector.size() / 2;
            median = (double) vector.get(midpoint);
        }

        return median;
    }

    public Integer mode() {
        // https://en.wikipedia.org/wiki/Mode_(statistics)

        int max = 0;
        int mode = 0;
        Map<Integer, Integer> histogram = new HashMap<>();

        for (int i : vector) {
            Integer count = histogram.get(i);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            histogram.put(i, count);
        }

        for (int i : histogram.keySet()) {
            if (max == 0) {
                max = histogram.get(i);
            } else if (histogram.get(i) > max) {
                max = histogram.get(i);
                mode = i;
            }
        }

        return mode;
    }

    public Double variance() {
        // https://en.wikipedia.org/wiki/Variance#Discrete_random_variable

        double mean = mean();
        double sum = 0;
        for (double i : vector) {
            if (sum == 0) {
                sum = Math.pow(i - mean, 2);
            } else {
                sum += Math.pow(i - mean, 2);
            }
        }

        // variance of entire population - hence Sum(stuff) / (N-1);
        return sum / (vector.size() - 1);
    }

    public Double stdDeviation() {
        // https://en.wikipedia.org/wiki/Standard_deviation
        // "...is the square root of its variance..."

        return Math.sqrt(variance());
    }

    public Double coefOfVariance() {
        // https://en.wikipedia.org/wiki/Coefficient_of_variation

        return stdDeviation() / mean() * 100;
    }

}
