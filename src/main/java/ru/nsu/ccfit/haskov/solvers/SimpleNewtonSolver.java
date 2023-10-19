package ru.nsu.ccfit.haskov.solvers;

import java.util.ArrayList;
import java.util.List;

public class SimpleNewtonSolver extends Solver{

    private final Double fixedNumber;
    private final Double x0;

    public SimpleNewtonSolver(Double a,
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
        this.fixedNumber = 1 / getDerivative(x0);
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
            x = prevX - fixedNumber * func(prevX);

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
        return doubleList;
    }

    public Double getDelta(Double prevX, Double x) {
        return Math.abs(prevX - x);
    }

    public Double getDerivative(double x) {
        return 3*x*x + 2*a*x + b;
    }
}
