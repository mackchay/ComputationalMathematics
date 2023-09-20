package ru.nsu.ccfit.haskov;

import java.util.*;

public class SolverTrinomial {

    private final Double a;
    private final Double b;
    private final Double c;
    private final Double epsilon;
    private Double delta;

    public SolverTrinomial(Double a,
                           Double b,
                           Double c,
                           Double epsilon,
                           Double delta
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.epsilon = epsilon;
        this.delta = Math.abs(delta);
    }
    public List<Double> start() {
        List<Double> roots = new ArrayList<>();
        Double d = 2 * a * 2 * a - 4 * 3 * b;
        if (d <= 0) {
            if (Math.abs(trinomialFunc((double) 0)) < epsilon) {
                roots.add((double)0);
            }
            if (trinomialFunc((double) 0) > epsilon) {
                roots.add(infLineSearch((double)0, Sign.NEGATIVE));
            }
            if (trinomialFunc((double) 0) < -epsilon) {
                roots.add(infLineSearch((double)0, Sign.POSITIVE));
            }
        }
        else {
            List<Double> nulls = getDerivativeRoots(d);
            Double alfa = nulls.get(0);
            Double beta = nulls.get(1);
            Double res1 = getDerivative(alfa);
            Double res2 = getDerivative(beta);

            if (trinomialFunc(alfa) > epsilon && trinomialFunc(beta) > epsilon) {
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
            }
            if (trinomialFunc(alfa) < -epsilon && trinomialFunc(beta) < -epsilon) {
                roots.add(infLineSearch(beta, Sign.POSITIVE));
            }
            if (trinomialFunc(alfa) > epsilon && Math.abs(trinomialFunc(beta)) < epsilon) {
                roots.add(beta);
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
            }
            if (Math.abs(trinomialFunc(alfa)) < epsilon && trinomialFunc(beta) < -epsilon) {
                roots.add(alfa);
                roots.add(infLineSearch(beta, Sign.POSITIVE));
            }
            if (trinomialFunc(alfa) > epsilon && trinomialFunc(beta) < -epsilon) {
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
                roots.add(infLineSearch(beta, Sign.POSITIVE));
                roots.add(lineSearch(alfa, beta));
            }
            if (Math.abs(trinomialFunc(alfa)) < epsilon && Math.abs(trinomialFunc(beta)) < epsilon) {
                roots.add((alfa + beta) / 2);
            }
        }
        Collections.sort(roots);
        return roots;
    }

    private Double getDerivative(Double x) {
        return 3*x*x + 2*a*x + b;
    }

    private Double trinomialFunc(Double x) {
        Double res = x*x*x + a*x*x + b*x + c;
        return x*x*x + a*x*x + b*x + c;
    }

    private Double lineSearch(Double a, Double b) {
        Double root = (a + b) / 2;
        if (trinomialFunc(a) > trinomialFunc(b)) {
            Double temp = a;
            a = b;
            b = temp;
        }
        while (Math.abs(trinomialFunc(root)) >= epsilon) {
            if (trinomialFunc(root) > epsilon) {
                b = root;
            }
            if (trinomialFunc(root) < -epsilon) {
                a = root;
            }
            root = (a + b) / 2;
        }
        return root;
    }
    private Double infLineSearch(Double x, Sign sign) {
        if (sign.equals(Sign.NEGATIVE)) {
            delta = -delta;
        }
        if (trinomialFunc(x) > 0) {
            while(trinomialFunc(x) > 0) {
                x += delta;
            }
        }
        else {
            while(trinomialFunc(x) < 0) {
                x += delta;
            }
        }
        Double result;
        if (delta > 0) {
            result = lineSearch(x - delta, x);
        }
        else {
            result = lineSearch(x, x - delta);
        }
        delta = Math.abs(delta);
        return result;
    }

    private List<Double> getDerivativeRoots(Double d) {
        List<Double> roots = new ArrayList<>();
        Double root1 = (-(2 * a) + Math.sqrt(d)) / (2 * 3);
        Double root2 = (-(2 * a) - Math.sqrt(d)) / (2 * 3);
        if (root1 < root2)  {
            roots.add(root1);
            roots.add(root2);
        }
        else {
            roots.add(root2);
            roots.add(root1);
        }
        return roots;
    }
}
