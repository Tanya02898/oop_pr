package ex2;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        boolean continueLoop = true;
        int number = 0;

        while (continueLoop) {
            int choice = solutionFinder.chooseAction();

            Calculation calculation = new Calculation();
            String result = "";

            switch (choice) {
                case 1:
                    number = enterNumber();
                    break;
                case 2:
                    result = calculation.toBinary(number);
                    break;
                case 3:
                    result = calculation.toOctal(number);
                    break;
                case 4:
                    result = calculation.toHexadecimal(number);
                    break;
                case 5:
                    String[] results = {calculation.toBinary(number), calculation.toOctal(number), calculation.toHexadecimal(number)};
                    SerializationManager.serializeResults(results);
                    System.out.println();
                    break;
                case 6:
                    String[] deserializedResults = SerializationManager.deserializeResults();
                    if (deserializedResults != null) {
                        System.out.println("Серіалізовані та десеріалізовані результати для числа: " + number);
                        System.out.println("Двійкове: " + deserializedResults[0]);
                        System.out.println("Вісімкове: " + deserializedResults[1]);
                        System.out.println("Шістнадцяткове: " + deserializedResults[2]);
                    }
                    System.out.println();
                    break;
                case 7:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Некоректний вибір дії.");
                    break;
            }

            if (choice >= 2 && choice <= 4 && continueLoop) {
                System.out.println("Результат: " + result);
            }
        }
    }

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число: ");
        return scanner.nextInt();
    }
}
