package ru.nsu.ccfit.haskov.solvers;

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
        return "n = " + x.toString()
                + "f(x_n) = " + f
                + "delta(x_n) = " + getDeltaX()
                + "delta(x_n) < e: " + isDeltaXLessEpsilon()
                + "delta(n) = " + getDeltaN(x)
                + "delta(n) < e: " + isDeltaNLessEpsilon()
                + "|f(x_n)| < e: " + isFunLessEpsilon()
                + "delta(n-1) < delta^2(n): " + isPrevLessThanCurSquared();
    }
}
