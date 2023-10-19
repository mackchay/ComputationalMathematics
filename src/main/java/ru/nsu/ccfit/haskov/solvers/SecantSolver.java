package ru.nsu.ccfit.haskov.solvers;

import java.util.ArrayList;
import java.util.List;

public class SecantSolver extends Solver {
    private final Double x0;
    private final Double x1;

    public SecantSolver(Double a,
                        Double b,
                        Double c,
                        Double epsilon,
                        Double z,
                        Double x0,
                        Double x1
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = z;
        this.x0 = x0;
        this.x1 = x1;
        this.epsilon = epsilon;
    }

    @Override
    public List<Double> start(Double alfa, Double beta) {
        return null;
    }

    @Override
    public List<Double> start() {
        List<Double> doubleList = new ArrayList<>();
        double xn = x0;
        double xn_1 = x1;
        int iteration = 0;
        int maxIterations = 10000;

        while (iteration < maxIterations) {
            double fxn = func(xn);
            double fxn_1 = func(xn_1);

            double xn_1_new = xn_1 - (fxn_1 * (xn_1 - xn)) / (fxn_1 - fxn);
            xn = xn_1;
            xn_1 = xn_1_new;

            iterationList.add(new SearchRootIteration(
                    (double) iterationList.size(),
                    xn_1,
                    func(xn_1),
                    xn,
                    epsilon,
                    z
            ));
            if (Math.abs(xn - xn_1) < epsilon) {
                doubleList.add(xn);
                return doubleList;
            }

            iteration++;
        }

        return doubleList;
    }
}
