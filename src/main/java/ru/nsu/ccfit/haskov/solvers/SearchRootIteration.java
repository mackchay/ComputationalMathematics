package ru.nsu.ccfit.haskov.solvers;

import java.text.DecimalFormat;

public record SearchRootIteration(
        Double iter,
        Double x,
        Double f,
        Double prevX,
        Double epsilon,
        Double z
    ) {

    public double getDeltaX() {
        return Math.abs(prevX - x);
    }

    public double getDeltaN(double x) {
        return Math.abs(x - z);
    }
    public boolean isDeltaXLessEpsilon() {
        return getDeltaX() < epsilon;
    }

    public boolean isDeltaNLessEpsilon() {
        return getDeltaN(x) < epsilon;
    }

    public boolean isFunLessEpsilon() {
        return Math.abs(f) < epsilon;
    }

    public boolean isPrevLessThanCurSquared() {
        return getDeltaN(prevX) < Math.pow(getDeltaN(x), 2.0);
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##########");
        return format.format(iter) +
                " " + format.format(x)
                + " " + format.format(f)
                + " " + format.format(getDeltaX())
                + " " + isDeltaXLessEpsilon()
                + " " + format.format(getDeltaN(x))
                + " " + isDeltaNLessEpsilon()
                + " " + isFunLessEpsilon()
                + " " + isPrevLessThanCurSquared();
    }
}
