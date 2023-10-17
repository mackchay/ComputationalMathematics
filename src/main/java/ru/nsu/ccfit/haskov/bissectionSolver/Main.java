package ru.nsu.ccfit.haskov.bissectionSolver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BisectionSolver solver = new BisectionSolver(
                (double) 0,
                (double) 0,
                (double) 0,
                0.00001,
                1000.0,
                0.0
        );
        List<Double> list = solver.start();
        System.out.println(list);
    }
}