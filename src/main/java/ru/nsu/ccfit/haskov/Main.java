package ru.nsu.ccfit.haskov;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SolverTrinomial solver = new SolverTrinomial(
                (double) 0,
                (double) 0,
                (double) 0,
                0.00005,
                1000.0
        );
        List<Double> list = solver.start();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("Hello world!");
    }
}