package ru.nsu.ccfit.haskov.bissectionSolver;

import ru.nsu.ccfit.haskov.solvers.SearchRootIteration;
import ru.nsu.ccfit.haskov.solvers.Solver;

import java.util.*;

public class BisectionSolver extends Solver {
    private Double delta;

    public BisectionSolver(Double a,
                           Double b,
                           Double c,
                           Double epsilon,
                           Double delta,
                           Double z
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = z;
        this.epsilon = epsilon;
        this.delta = Math.abs(delta);
    }

    @Override
    public List<Double> start() {
        Double d = 2 * a * 2 * a - 4 * 3 * b;
        List<Double> nulls = getDerivativeRoots(d);
        Double alfa = nulls.get(0);
        Double beta = nulls.get(1);
        return start(alfa, beta);
    }

    @Override
    public List<Double> start(Double alfa, Double beta) {
        List<Double> roots = new ArrayList<>();
        Double d = 2 * a * 2 * a - 4 * 3 * b;
        if (d <= 0) {
            if (Math.abs(func((double) 0)) < epsilon) {
                roots.add((double) 0);
                roots.add((double) 0);
                roots.add((double) 0);
            }
            if (func((double) 0) > epsilon) {
                roots.add(infLineSearch((double)0, Sign.NEGATIVE));
                roots.add(infLineSearch((double)0, Sign.NEGATIVE));
                roots.add(infLineSearch((double)0, Sign.NEGATIVE));
            }
            if (func((double) 0) < -epsilon) {
                roots.add(infLineSearch((double)0, Sign.POSITIVE));
                roots.add(infLineSearch((double)0, Sign.POSITIVE));
                roots.add(infLineSearch((double)0, Sign.POSITIVE));
            }
        }
        else {
            if (func(alfa) > epsilon && func(beta) > epsilon) {
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
            }
            if (func(alfa) < -epsilon && func(beta) < -epsilon) {
                roots.add(infLineSearch(beta, Sign.POSITIVE));
            }
            if (func(alfa) > epsilon && Math.abs(func(beta)) < epsilon) {
                roots.add(beta);
                roots.add(beta);
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
            }
            if (Math.abs(func(alfa)) < epsilon && func(beta) < -epsilon) {
                roots.add(alfa);
                roots.add(alfa);
                roots.add(infLineSearch(beta, Sign.POSITIVE));
            }
            if (func(alfa) > epsilon && func(beta) < -epsilon) {
                roots.add(infLineSearch(alfa, Sign.NEGATIVE));
                roots.add(infLineSearch(beta, Sign.POSITIVE));
                roots.add(lineSearch(alfa, beta));
            }
            if (Math.abs(func(alfa)) < epsilon && Math.abs(func(beta)) < epsilon) {
                roots.add((alfa + beta) / 2);
            }
        }
        Collections.sort(roots);
        return roots;
    }

    public Double func(Double x) {
        return x*x*x + a*x*x + b*x + c;
    }

    private Double lineSearch(Double a, Double b) {
        Double root = (a + b) / 2;
        if (func(a) > func(b)) {
            Double temp = a;
            a = b;
            b = temp;
        }
        while (Math.abs(func(root)) >= epsilon) {
            if (func(root) > epsilon) {
                b = root;
            }
            if (func(root) < -epsilon) {
                a = root;
            }
            double prevRoot = root;
            root = (a + b) / 2;
            iterationList.add(new SearchRootIteration(
                    (double)iterationList.size(),
                    root,
                    func(root),
                    prevRoot,
                    epsilon,
                    z
            ));
        }
        return root;
    }
    private Double infLineSearch(Double x, Sign sign) {
        if (sign.equals(Sign.NEGATIVE)) {
            delta = -delta;
        }
        if (func(x) > 0) {
            while(func(x) > 0) {
                x += delta;
            }
        }
        else {
            while(func(x) < 0) {
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
