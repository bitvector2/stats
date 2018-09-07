package org.bitvector.stats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("##.00");

        List<Integer> testVector = new ArrayList<>();
        testVector.add(50);
        testVector.add(23);
        testVector.add(1);
        testVector.add(23);
        testVector.add(100);
        testVector.add(30);

        System.out.println("*** Vector Stats ***");
        System.out.println("Mean: " + f.format(Statistics.mean(testVector)));
        System.out.println("Median: " + f.format(Statistics.median(testVector)));
        System.out.println("Mode: " + f.format(Statistics.mode(testVector)));
        System.out.println("Variance: " + f.format(Statistics.variance(testVector)));
        System.out.println("StdDev: " + f.format(Statistics.stdDeviation(testVector)));
        System.out.println("CoefOfVar: " + f.format(Statistics.coefOfVariance(testVector)));

        Map<Double, Double> initMap = new HashMap<>();
        initMap.put(1.0, (0.0 / 100));
        initMap.put(2.0, (5.0 / 100));
        initMap.put(4.0, (5.0 / 100));
        initMap.put(15.0, (85.0 / 100));
        initMap.put(35.0, (5.0 / 100));
        initMap.put(100.0, (0.0 / 100));
        ProbabilityMassFunction testPMF = new ProbabilityMassFunction(initMap);

        System.out.println("*** PMF Stats ***");
        System.out.println("Mean: " + f.format(Statistics.mean(testPMF)));
        System.out.println("Median: " + f.format(Statistics.median(testPMF)));
        System.out.println("Mode: " + f.format(Statistics.mode(testPMF)));
        System.out.println("Variance: " + f.format(Statistics.variance(testPMF)));
        System.out.println("StdDev: " + f.format(Statistics.stdDeviation(testPMF)));
        System.out.println("CoefOfVar: " + f.format(Statistics.coefOfVariance(testPMF)));
    }

}
