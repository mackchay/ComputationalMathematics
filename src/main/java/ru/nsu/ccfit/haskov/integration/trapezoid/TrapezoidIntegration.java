package ru.nsu.ccfit.haskov.integration.trapezoid;

import ru.nsu.ccfit.haskov.integration.Integration;

public class TrapezoidIntegration extends Integration {
    public static void main(String[] args) {
        int segments = Integer.parseInt(args[0]);
        TrapezoidIntegration integration = new TrapezoidIntegration();
        System.out.println("Result: " + integration.start(segments));
    }

    @Override
    public double start(int segments) {
        double result = 0;

        double height = LENGTH / segments;
        for (int i = 0; i < segments - 1; i++) {
            result += (func(BEGIN + i*height) + func(BEGIN + (i + 1) * height))/2 * height;
        }
        return result;
    }
}
