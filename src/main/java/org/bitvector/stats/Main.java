package org.bitvector.stats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {

    public static void main(String[] args) {
        DecimalFormat f = new DecimalFormat("0.00");

        List<Integer> initList = new ArrayList<>();
        initList.add(50);
        initList.add(23);
        initList.add(1);
        initList.add(23);
        initList.add(100);
        initList.add(30);
        IntegerVector testIV = new IntegerVector(initList);

        System.out.println("*** IntegerVector Stats ***");
        System.out.println("Mean: " + f.format(testIV.mean()));
        System.out.println("Median: " + f.format(testIV.median()));
        System.out.println("Mode: " + f.format(testIV.mode()));
        System.out.println("Variance: " + f.format(testIV.variance()));
        System.out.println("StdDev: " + f.format(testIV.stdDeviation()));
        System.out.println("CoefOfVar: " + f.format(testIV.coefOfVariance()));

        Map<Double, Double> initMap = new HashMap<>();
        initMap.put(1.0, (0.0 / 100));
        initMap.put(2.0, (5.0 / 100));
        initMap.put(4.0, (5.0 / 100));
        initMap.put(15.0, (85.0 / 100));
        initMap.put(35.0, (5.0 / 100));
        initMap.put(100.0, (0.0 / 100));
        ProbabilityMassFunction testPMF = new ProbabilityMassFunction(initMap);

        System.out.println("*** ProbabilityMassFunction Stats ***");
        System.out.println("Mean: " + f.format(testPMF.mean()));
        System.out.println("Median: " + f.format(testPMF.median()));
        System.out.println("Mode: " + f.format(testPMF.mode()));
        System.out.println("Variance: " + f.format(testPMF.variance()));
        System.out.println("StdDev: " + f.format(testPMF.stdDeviation()));
        System.out.println("CoefOfVar: " + f.format(testPMF.coefOfVariance()));
    }

}
