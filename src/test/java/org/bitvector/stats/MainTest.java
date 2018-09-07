package org.bitvector.stats;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void testIV() {
        ArrayList<Integer> initList = new ArrayList<>();
        initList.add(50);
        initList.add(23);
        initList.add(1);
        initList.add(23);
        initList.add(100);
        initList.add(30);
        IntegerVector testIV = new IntegerVector(initList);

        System.out.println("*** IntegerVector Stats ***");

        System.out.println("Mean: " + Precision.round(testIV.mean(), 2));
        assertEquals(37.83, Precision.round(testIV.mean(), 2));

        System.out.println("Median: " + Precision.round(testIV.median(), 1));
        assertEquals(26.5, Precision.round(testIV.median(), 1));

        System.out.println("Mode: " + testIV.mode());
        assertEquals(23, Precision.round(testIV.mode(), 0));

        System.out.println("Variance: " + Precision.round(testIV.variance(), 2));

        System.out.println("StdDev: " + Precision.round(testIV.stdDeviation(), 2));
        assertEquals(34.27, Precision.round(testIV.stdDeviation(), 2));

        System.out.println("CoefOfVar: " + Precision.round(testIV.coefOfVariance(), 2));
        assertEquals(90.57, Precision.round(testIV.coefOfVariance(), 2));

    }

    @Test
    void testPMF() {
        TreeMap<Double, Double> initMap = new TreeMap<>();
        initMap.put(1.0, (0.0 / 100));
        initMap.put(2.0, (5.0 / 100));
        initMap.put(4.0, (5.0 / 100));
        initMap.put(15.0, (85.0 / 100));
        initMap.put(35.0, (5.0 / 100));
        initMap.put(100.0, (0.0 / 100));
        ProbabilityMassFunction testPMF = new ProbabilityMassFunction(initMap);

        System.out.println("*** ProbabilityMassFunction Stats ***");
        System.out.println("Mean: " + testPMF.mean());
        System.out.println("Median: " + testPMF.median());
        System.out.println("Mode: " + testPMF.mode());
        System.out.println("Variance: " + testPMF.variance());
        System.out.println("StdDev: " + testPMF.stdDeviation());
        System.out.println("CoefOfVar: " + testPMF.coefOfVariance());
    }

}
