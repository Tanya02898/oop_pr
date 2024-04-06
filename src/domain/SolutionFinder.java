package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть число: ");
        return scanner.nextInt();
    }

    public int chooseAction() {
        System.out.println("Оберіть дію: ");
        System.out.println("1. Двійкове представлення");
        System.out.println("2. Вісімкове представлення");
        System.out.println("3. Шістнадцяткове представлення");
        System.out.println("4. Серіалізація");
        System.out.println("5. Десеріалізація");
        return scanner.nextInt();
    }
}
