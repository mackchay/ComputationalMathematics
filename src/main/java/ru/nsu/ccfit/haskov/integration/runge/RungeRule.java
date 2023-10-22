package ru.nsu.ccfit.haskov.integration.runge;

import ru.nsu.ccfit.haskov.integration.Integration;
import ru.nsu.ccfit.haskov.integration.custom.CustomIntegration;
import ru.nsu.ccfit.haskov.integration.simpson.SimpsonIntegration;
import ru.nsu.ccfit.haskov.integration.trapezoid.TrapezoidIntegration;

public class RungeRule {
    private static final int SEGMENTS = 1800;
    public static void main(String[] args) {
        Integration trapezoid = new TrapezoidIntegration();
        Integration simpson = new SimpsonIntegration();
        Integration custom = new CustomIntegration();
        System.out.println("Trapezoid: " + getOrderOfAccuracy(trapezoid));
        System.out.println("Simpson: " + getOrderOfAccuracy(simpson));
        System.out.println("Custom: " + getOrderOfAccuracy(custom));
    }

    public static double getOrderOfAccuracy(Integration integration) {
        double s1 = integration.start(SEGMENTS);
        double s2 = integration.start(SEGMENTS * 2);
        double s3 = integration.start(SEGMENTS * 4);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s1 - s2);
        System.out.println(s2 - s3);
        System.out.println((s1 - s2) / (s2 - s3));
        return Math.log(Math.abs((s1 - s2) / (s2 - s3))) / Math.log(2);
    }
}
