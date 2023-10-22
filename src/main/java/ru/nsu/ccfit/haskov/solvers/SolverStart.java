package ru.nsu.ccfit.haskov.solvers;

import ru.nsu.ccfit.haskov.bissectionSolver.BisectionSolver;

import java.util.List;

public class SolverStart {

    private static final double Z1 = -1.76929235;
    private static final double X1 = -2;

    private static final double X12 = (X1 + Z1) / 2;

    private static final double Z2 = -3.89102041;
    private static final double X2 = -3.6;
    private static final double X22 = (X2 + Z2) / 2;

    private static final double Z3 = 2.76081783;
    private static final double X3 = 2;
    private static final double X33 = (X3 + Z3) / 2;

    public static void startSolver(Solver solver) {
        List<Double> answer = solver.start();
        for (SearchRootIteration it: solver.getIterationList()) {
            System.out.println(it);
        }
    }
    public static void main(String[] args) {
        Solver solver1 = new BisectionSolver(
                0.0,
                -2.0,
                2.0,
                0.00001,
                0.1,
                Z1
        );
        Solver solver2 = new NewtonSolver(
                0.0,
                -2.0,
                2.0,
                0.00001,
                Z1,
                X1
        );
        Solver solver3 = new SimpleNewtonSolver(
                0.0,
                -2.0,
                2.0,
                0.00001,
                Z1,
                X1
        );
        Solver solver4 = new SecantSolver(
                0.0,
                -2.0,
                2.0,
                0.00001,
                Z1,
                X1,
                X12
        );
        Solver solver5 = new BisectionSolver(
                0.0,
                -10.0,
                20.0,
                0.00001,
                0.1,
                Z2
        );
        Solver solver6 = new NewtonSolver(
                0.0,
                -10.0,
                20.0,
                0.00001,
                Z2,
                X2
        );
        Solver solver7 = new SimpleNewtonSolver(
                0.0,
                -10.0,
                20.0,
                0.00001,
                Z2,
                X2
        );
        Solver solver8 = new SecantSolver(
                0.0,
                -10.0,
                20.0,
                0.00001,
                Z2,
                X2,
                X22
        );
        Solver solver9 = new BisectionSolver(
                0.0,
                -4.0,
                -10.0,
                0.00001,
                0.1,
                Z3
        );
        Solver solver10 = new NewtonSolver(
                0.0,
                -4.0,
                -10.0,
                0.00001,
                Z3,
                X3
        );
        Solver solver11 = new SimpleNewtonSolver(
                0.0,
                -4.0,
                -10.0,
                0.00001,
                Z3,
                2.5
        );
        Solver solver12 = new SecantSolver(
                0.0,
                -4.0,
                -10.0,
                0.00001,
                Z3,
                X3,
                X33
        );
        startSolver(solver1);
    }
}
