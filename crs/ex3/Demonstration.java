package ex3;

import java.util.Scanner;

public class Demonstration {

    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);

        int number = solutionFinder.findSolution();
        String binary = calculation.toBinary(number);
        String octal = calculation.toOctal(number);
        String hexadecimal = calculation.toHexadecimal(number);

        System.out.println("Представлення в різних системах числення числа " + number + ":");
        System.out.println("Двійкове: " + binary);
        System.out.println("Вісімкове: " + octal);
        System.out.println("Шістнадцяткове: " + hexadecimal);
    }
}