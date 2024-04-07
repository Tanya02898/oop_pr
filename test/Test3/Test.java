package test.Test3;

import ex3.Calculation;
import ex3.SolutionFinder;

public class Test {

    public static void main(String[] args) {
        if (testCalculation() && testSolutionFinder()) {
            System.out.println("Коректність роботи програми підтверджена.");
        } else {
            System.out.println("Програма працює некоректно.");
        }
    }

    public static boolean testCalculation() {
        Calculation calculation = new Calculation();
        int testNumber = 42;

        try {
            String binaryResult = calculation.toBinary(testNumber);
            String expectedBinary = "101010";
            if (!binaryResult.equals(expectedBinary)) {
                return false;
            }

            String octalResult = calculation.toOctal(testNumber);
            String expectedOctal = "52";
            if (!octalResult.equals(expectedOctal)) {
                return false;
            }

            String hexResult = calculation.toHexadecimal(testNumber);
            String expectedHex = "2A";
            if (!hexResult.equals(expectedHex)) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testSolutionFinder() {
        SolutionFinder solutionFinder = new SolutionFinder();

        try {

            int testInput = 42;
            int foundNumber = solutionFinder.findSolution();
            return foundNumber == testInput;
        } catch (Exception e) {
            return false;
        }
    }
}
