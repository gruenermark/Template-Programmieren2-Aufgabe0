package org.htw.prog2.aufgabe0;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;

import java.util.ArrayList;
import java.util.List;

public class MyProject {

    /**
     * Calculate root X of a value S according to babylonian algorithm, starting with
     * an initial estimate X(0):
     * <ol>
     *     <li>Estimate the error e(n): e(n)=(S-X(n-1)²)/(2*X(n-1))</li>
     *     <li>Calculate X(n): X(n)=X(n-1)+e(n)</li>
     * </ol>
     * Continue until the estimated error reaches the desired maximum error
     *
     * @param value    The value to calculate the root of
     * @param initial  The initial value to start the calculation with
     * @param maxerror The maximum allowed error
     * @return An array containing the values of all iterations. The last value in the array is the final estimate.
     */
    public static double[] calculateBabylonianRoot(double value, double initial, double maxerror) {
        // TODO: Implementieren.
        if (value <= 0) {
            return new double[]{0};
        }
        double estimateError;
        double estimateRoot = initial;

        List<Double> liste = new ArrayList<>();
        do {
            estimateError = (value - (estimateRoot * estimateRoot)) / (2 * estimateRoot);
            estimateRoot = estimateRoot + estimateError;
            System.out.println(estimateError);
            System.out.println(estimateRoot);
            liste.add(estimateRoot);

        } while (Math.abs(estimateError) >= Math.abs(maxerror));
        double[] rootArray = new double[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            rootArray[i] = liste.get(i);
        }
        return rootArray;
    }

    public static void plotData(double[] values) {
        XYChart chart = new XYChart(500, 500);
        chart.addSeries("Data", values);
        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        plotData(calculateBabylonianRoot(74821, 5, 0.1));
    }

}