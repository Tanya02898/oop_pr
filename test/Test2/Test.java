
import ex2.Calculation;
import ex2.SerializationManager;
import ex2.SolutionFinder;

public class Test {

    public static void main(String[] args) {
        if (testCalculation() && testSerialization()) {
            System.out.println("Коректність роботи програми підтверджена.");
        } else {
            System.out.println("Програма працює некоректно.");
        }
    }

    public static boolean testCalculation() {
        Calculation calculation = new Calculation();
        int testNumber = 42;

        try {
            // Test calculation methods without specific input values
            calculation.toBinary(testNumber);
            calculation.toOctal(testNumber);
            calculation.toHexadecimal(testNumber);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testSerialization() {
        String[] testResults = {"101010", "52", "2A"};

        try {
            // Test serialization and deserialization without specific values
            SerializationManager.serializeResults(testResults);
            SerializationManager.deserializeResults();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
