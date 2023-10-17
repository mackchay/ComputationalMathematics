package ru.nsu.ccfit.haskov.integration.simpson;

import ru.nsu.ccfit.haskov.integration.Integration;
import ru.nsu.ccfit.haskov.integration.trapezoid.TrapezoidIntegration;

public class SimpsonIntegration extends Integration {

    public static void main(String[] args) {
        int segments = Integer.parseInt(args[0]);
        if (segments % 2 != 0) {
            System.out.println("ERROR: Number of segments should be even!");
            return;
        }
        SimpsonIntegration integration = new SimpsonIntegration();
        System.out.println("Result: " + integration.start(segments));
    }

    @Override
    public double start(int segments) {
        double result = func(BEGIN) + func(END);
        double height = LENGTH / segments;
        for (int i = 1; i < segments; i++) {
            double x = BEGIN + i * height;
            double factor = (i % 2 == 0) ? 2 : 4;
            result += factor * func(x);
        }
        result *= height / 3;
        return result;
    }
}
