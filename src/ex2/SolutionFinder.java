package ex2;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int chooseAction() {
        System.out.println("______________________________________");
        System.out.println("МENU:");
        System.out.println("1. Ввести число");
        System.out.println("2. Двійкове представлення");
        System.out.println("3. Вісімкове представлення");
        System.out.println("4. Шістнадцяткове представлення");
        System.out.println("5. Серіалізація");
        System.out.println("6. Десеріалізація");
        System.out.println("7. Вихід");
        System.out.println("______________________________________");
        return scanner.nextInt();
    }
}
