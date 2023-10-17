package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.ccfit.haskov.bissectionSolver.BisectionSolver;

import java.util.List;

public class BisectionSolverTest {

    @Test
    public void testThreeRoots() {
        Double epsilon = 0.00005;
        BisectionSolver solver = new BisectionSolver(
                2123.02,
                202342.46,
                4046.0,
                epsilon,
                7.0,
                0.0
        );
        Double expected1 = -2023.0;
        Double expected2 = -100.0;
        Double expected3 = -0.02000000;
        List<Double> actual = solver.start();
        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
        Assertions.assertTrue(Math.abs(actual.get(1) - expected2) < epsilon);
        Assertions.assertTrue(Math.abs(actual.get(2) - expected3) < epsilon);
    }

    @Test
    public void testZeros() {
        Double epsilon = 0.00005;
        BisectionSolver solver = new BisectionSolver(
                0.0,
                0.0,
                0.0,
                epsilon,
                1000.0,
                0.0
        );
        Double expected1 = 0.0;
        List<Double> actual = solver.start();
        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
    }

    @Test
    public void testTwoZeros() {
        Double epsilon = 0.00005;
        BisectionSolver solver = new BisectionSolver(
                -333333.0,
                0.0,
                0.0,
                epsilon,
                107.0,
                0.0
        );
        Double expected1 = 0.0;
        Double expected2 = 333333.0;
        List<Double> actual = solver.start();
        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
        Assertions.assertTrue(Math.abs(actual.get(1) - expected2) < epsilon);
    }

    @Test
    public void testOneRoot() {
        Double epsilon = 0.00005;
        BisectionSolver solver = new BisectionSolver(
                110981.0,
                -2219920.0,
                11100100.0,
                epsilon,
                7.77,
                0.0
        );
        Double expected1 = -111001.0;
        List<Double> actual = solver.start();
        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
    }
    @Test
    public void CustomTest() {
        Double epsilon = 0.00005;
        BisectionSolver solver = new BisectionSolver(
                0.0,
                100.23,
                0.0,
                epsilon,
                200.0,
                0.0
        );
        Double expected1 = 0.0;
        List<Double> actual = solver.start();
        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
    }

//    @Test
//    public void CustomTest1() {
//        Double epsilon = 0.00005;
//        SolverTrinomial solver = new SolverTrinomial(
//                0.0,
//                100.23,
//                0.0,
//                epsilon,
//                200.0
//        );
//        Double expected1 = 0.0;
//        List<Double> actual = solver.start();
//        Assertions.assertTrue(Math.abs(actual.get(0) - expected1) < epsilon);
//    }
}
