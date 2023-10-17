package ru.nsu.ccfit.haskov.solvers;

import java.util.ArrayList;
import java.util.List;

public abstract class Solver {
    protected Double a;
    protected Double b;
    protected Double c;
    protected Double epsilon;
    protected List<SearchRootIteration> iterationList = new ArrayList<>();
    protected Double z;

    public abstract List<Double> start(Double alfa, Double beta);
    public abstract List<Double> start();

    public List<SearchRootIteration> getIterationList() {
        return iterationList;
    }
}
