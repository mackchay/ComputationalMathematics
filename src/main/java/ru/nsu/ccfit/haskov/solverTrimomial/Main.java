package ru.nsu.ccfit.haskov.solverTrimomial;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SolverTrinomial solver = new SolverTrinomial(
                (double) 0,
                (double) 0,
                (double) 0,
                0.00001,
                1000.0
        );
        List<Double> list = solver.start();
        System.out.println(list);
//        for (Double i: list) {
//            System.out.print("Fun results: " + solver.trinomialFunc(i) + " ");
//        }
    }
}