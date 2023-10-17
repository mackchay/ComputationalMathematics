package ru.nsu.ccfit.haskov.solvers;

import ru.nsu.ccfit.haskov.bissectionSolver.BisectionSolver;

import java.util.List;

public class SolverStart {

    private static final double Z1 = -1.76929235;
    public static void main(String[] args) {
        Solver solver = new BisectionSolver(
                0.0,
                -2.0,
                2.0,
                0.00001,
                0.1,
                Z1
        );
        List<Double> bisection1 = solver.start(-2.0, -1.0);
        for (SearchRootIteration it: solver.getIterationList()) {
            System.out.println(it);
        }
    }
}
