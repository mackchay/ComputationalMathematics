package ru.nsu.ccfit.haskov.integration;

public abstract class Integration {
    protected static final double ANSWER = 823.72;
    protected static final double BEGIN = 5.0;
    protected static final double END = 7.0;

    protected static final double LENGTH = END - BEGIN;

    public abstract double start(int segments);

    protected double func(double x) {
        return Math.exp(x) * Math.cos(x);
    }
}
