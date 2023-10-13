package ru.nsu.ccfit.haskov.integration.custom;

import ru.nsu.ccfit.haskov.integration.Integration;
import ru.nsu.ccfit.haskov.integration.simpson.SimpsonIntegration;

public class CustomIntegration extends Integration {

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
        for (int i = 1; i < segments - 1; i++) {
            result += 4 * func(BEGIN + i * height);
        }
        result *= height / 6;
        return result;
    }
}
