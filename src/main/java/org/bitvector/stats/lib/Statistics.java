package org.bitvector.stats.lib;


import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    static Double mean(List<Integer> vector) {
        // https://en.wikipedia.org/wiki/Mean#Arithmetic_mean_(AM)

        double tally = vector.stream().mapToInt(Integer::intValue).sum();
        return tally / vector.size();
    }

    static Double median(List<Integer> vector) {
        // https://en.wikipedia.org/wiki/Median

        double median;
        Collections.sort(vector);

        if (vector.size() % 2 == 0) {   // case of even size vector
            int overMidpoint = vector.size() / 2;
            int underMidpoint = overMidpoint - 1;
            median = ((vector.get(underMidpoint) + vector.get(overMidpoint)) / 2.0);

        } else {                        // case of odd size vector
            int midpoint = vector.size() / 2;
            median = (double) vector.get(midpoint);
        }

        return median;
    }

    static Integer mode(List<Integer> vector) {
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

    static Double variance(List<Integer> vector) {
        // https://en.wikipedia.org/wiki/Variance#Discrete_random_variable

        double mean = mean(vector);
        double sum = 0;
        for (double i : vector) {
            if (sum == 0) {
                sum = Math.pow(i - mean, 2);
            } else {
                sum += Math.pow(i - mean, 2);
            }
        }

        // variance of entire population vs a subset - hence Sum(stuff) / (N-1);
        return sum / (vector.size() - 1);
    }

    static Double stdDeviation(List<Integer> vector) {
        // https://en.wikipedia.org/wiki/Standard_deviation
        // "...is the square root of its variance..."

        return Math.sqrt(variance(vector));
    }

    static Double coefOfVariance(List<Integer> vector) {
        // https://en.wikipedia.org/wiki/Coefficient_of_variation

        return stdDeviation(vector) / mean(vector) * 100;
    }

    public static Double mean(ProbabilityMassFunction testPMF) {
        return 0.0; // FIXME
    }

    public static Double median(ProbabilityMassFunction testPMF) {
        return 0.0; // FIXME
    }

    public static Integer mode(ProbabilityMassFunction testPMF) {
        return 0; // FIXME
    }

    public static Double variance(ProbabilityMassFunction testPMF) {
        return 0.0; // FIXME
    }

    public static Double stdDeviation(ProbabilityMassFunction testPMF) {
        return 0.0; // FIXME
    }

    public static double coefOfVariance(ProbabilityMassFunction testPMF) {
        return 0.0; // FIXME
    }
}
