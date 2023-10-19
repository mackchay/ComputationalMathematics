package ru.nsu.ccfit.haskov.solvers;

import java.util.ArrayList;
import java.util.List;

public class NewtonSolver extends Solver {
    private final Double x0;
    public NewtonSolver(Double a,
                           Double b,
                           Double c,
                           Double epsilon,
                           Double z,
                            Double x0
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = z;
        this.x0 = x0;
        this.epsilon = epsilon;
    }
    @Override
    public List<Double> start(Double alfa, Double beta) {
        return null;
    }

    @Override
    public List<Double> start() {
        List<Double> doubleList = new ArrayList<>();
        Double prevX;
        Double x = x0;
        int maxIterations = 10000;
        int iteration = 0;
        while (iteration < maxIterations) {
            prevX = x;
            x = prevX - func(prevX) / getDerivative(prevX);

            if (Math.abs(getDerivative(x)) < epsilon) {
                return doubleList;
            }

            iterationList.add(new SearchRootIteration(
                    (double) iterationList.size(),
                    x,
                    func(x),
                    prevX,
                    epsilon,
                    z
            ));
            iteration++;
            if (getDelta(prevX, x) < epsilon) {
                doubleList.add(x);
                return doubleList;
            }
        };
        doubleList.add(x);
        return doubleList;
    }

    public Double getDelta(Double prevX, Double x) {
        return Math.abs(prevX - x);
    }
    public Double getDerivative(double x) {
        return 3*x*x + 2*a*x + b;
    }
}
