package ru.nsu.ccfit.haskov.thomas;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThomasSolver {
    public static void main(String[] args) {

        double e = 0.000001;
        int n = 7;
        double gamma = 1.5;
        double[] c = new double[n];
        double[] a = new double[n];
        double[] b = new double[n];
        double[] f = new double[n];
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        Arrays.fill(f, 2 + e);
        double[] alfa = new double[n - 1];
        double[] beta = new double[n];
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            c[i] = 2*(i + 1) + gamma;
            f[i] = 2*(i + 2) + gamma;
        }

        alfa[0] = -b[0] / c[0];
        beta[0] = f[0] / c[0];
        for (int i = 1; i < n - 1; i++) {
            double m = a[i - 1] * alfa[i - 1] + c[i];
            alfa[i] = -b[i] / m;
            beta[i] = (f[i] - a[i - 1] * beta[i - 1]) / m;
        }
        beta[n - 1] = (f[n - 1] - a[n - 2] * beta[n - 2]) / (a[n - 2] * alfa[n - 2] + c[n - 1]);

        x[n - 1] = beta[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            x[i] = (x[i + 1] * alfa[i]) + beta[i];
        }
        System.out.println(Arrays.toString(x));
    }

}
