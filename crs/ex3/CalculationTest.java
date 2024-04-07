package ex3;

import java.io.*;
import java.util.Scanner;

public class CalculationTest {

    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int number = 0;
        String binary = "";
        String octal = "";
        String hexadecimal = "";

        do {
            System.out.println("___________________________________________________________");
            System.out.println("МENU:");
            System.out.println("1. Ввести нове число.");
            System.out.println("2. Відобразити представлення в різних системах числення.");
            System.out.println("3. Зберегти результат.");
            System.out.println("4. Відновити результат.");
            System.out.println("5. Закінчити програму.");
            System.out.println("___________________________________________________________");
            System.out.println("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    number = solutionFinder.findSolution();
                    break;
                case 2:
                    if (number != 0) {
                        binary = calculation.toBinary(number);
                        octal = calculation.toOctal(number);
                        hexadecimal = calculation.toHexadecimal(number);
                        System.out.println("Представлення в різних системах числення числа " + number + ":");
                        System.out.println("Двійкове: " + binary);
                        System.out.println("Вісімкове: " + octal);
                        System.out.println("Шістнадцяткове: " + hexadecimal);
                    } else {
                        System.out.println("Спочатку введіть число.");
                    }
                    break;
                case 3:
                    if (number != 0) {
                        saveResults(number, binary, octal, hexadecimal);
                        System.out.println("Результат збережено.");
                    } else {
                        System.out.println("Немає результатів для збереження.");
                    }
                    break;
                case 4:
                    int[] restoredData = restoreResults();
                    if (restoredData != null) {
                        number = restoredData[0];
                        binary = calculation.toBinary(number);
                        octal = calculation.toOctal(number);
                        hexadecimal = calculation.toHexadecimal(number);
                        System.out.println("Результат відновлено.");
                        System.out.println("Представлення в різних системах числення числа " + number + ":");
                        System.out.println("Двійкове: " + binary);
                        System.out.println("Вісімкове: " + octal);
                        System.out.println("Шістнадцяткове: " + hexadecimal);
                    } else {
                        System.out.println("Немає збережених результатів.");
                    }
                    break;
                case 5:
                    System.out.println("Програма завершує роботу.");
                    break;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 5);
    }

    private static void saveResults(int number, String binary, String octal, String hexadecimal) {
        try (PrintWriter writer = new PrintWriter("results.txt")) {
            writer.println(number);
            writer.println(binary);
            writer.println(octal);
            writer.println(hexadecimal);
        } catch (IOException e) {
            System.err.println("Помилка при збереженні результатів: " + e.getMessage());
        }
    }

    private static int[] restoreResults() {
        try (BufferedReader reader = new BufferedReader(new FileReader("results.txt"))) {
            int number = Integer.parseInt(reader.readLine());
            return new int[]{number};
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка при відновленні результатів: " + e.getMessage());
            return null;
        }
    }
}
