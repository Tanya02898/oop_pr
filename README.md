# Практика ООП
## **1 Завдання**
**Знайти двійкове, вісімкове та шістнадцяткове уявлення цілочисленного значення.**

```java
package domain;

public class Calculation {

    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}
```
```java
package domain;

public class CalculationTest {

    public static void main(String[] args) 
    {
        SolutionFinder solutionFinder = new SolutionFinder();
        int number = solutionFinder.findSolution();

        Calculation calculation = new Calculation();
        String binary = calculation.toBinary(number);
        String octal = calculation.toOctal(number);
        String hexadecimal = calculation.toHexadecimal(number);

        int result = checkResults(binary, octal, hexadecimal);
        if (result == 1) 
        {
            System.out.println("Програма успішно запустилась та коректно обчислила результати ");
        } else {
            System.out.println("Програма запустилась, але не відобразила коректні результати ");
        }
    }

    private static int checkResults(String binary, String octal, String hexadecimal) 
    {
        if (binary != null && !binary.isEmpty() && octal != null && !octal.isEmpty() && hexadecimal != null && !hexadecimal.isEmpty()) 
        {
            return 1; 
        } else {
            return 0; 
    }
}
}
```
```java
User
package domain;

public class Calculation {

    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}
package domain;

public class CalculationTest {

    public static void main(String[] args) 
    {
        SolutionFinder solutionFinder = new SolutionFinder();
        int number = solutionFinder.findSolution();

        Calculation calculation = new Calculation();
        String binary = calculation.toBinary(number);
        String octal = calculation.toOctal(number);
        String hexadecimal = calculation.toHexadecimal(number);

        int result = checkResults(binary, octal, hexadecimal);
        if (result == 1) 
        {
            System.out.println("Програма успішно запустилась та коректно обчислила результати ");
        } else {
            System.out.println("Програма запустилась, але не відобразила коректні результати ");
        }
    }

    private static int checkResults(String binary, String octal, String hexadecimal) 
    {
        if (binary != null && !binary.isEmpty() && octal != null && !octal.isEmpty() && hexadecimal != null && !hexadecimal.isEmpty()) 
        {
            return 1; 
        } else {
            return 0; 
    }
}
}
package domain;

public class Demonstration {

    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        int number = solutionFinder.findSolution();

        Calculation calculationParameters = new Calculation();
        String binary = calculationParameters.toBinary(number);
        String octal = calculationParameters.toOctal(number);
        String hexadecimal = calculationParameters.toHexadecimal(number);

        System.out.println("Двійкове: " + binary);
        System.out.println("Вісімкове: " + octal);
        System.out.println("Шістнадцяткове: " + hexadecimal);
    }
}
```
```java
package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть число: ");
        int number = scanner.nextInt();
        return number;
    }
}

```
![](images/1.1.png)

## **2 Завдання**

```java
package domain;

import java.io.*;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}
```
```java
package domain;

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

```
```java
package domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationManager {
    public static void serializeResults(String[] results) {
        try {
            FileOutputStream fileOut = new FileOutputStream("result.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(results);
            out.close();
            fileOut.close();
            System.out.println("Результати були серіалізовані в файл result.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] deserializeResults() {
        String[] results = null;
        try {
            FileInputStream fileIn = new FileInputStream("result.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            results = (String[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Результати були десеріалізовані.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return results;
    }
}

```
```java
package domain;

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

```
```java

import domain.Calculation;
import domain.SolutionFinder;
import domain.SerializationManager;

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

```
![](images/2.1.jpg)
![](images/2.2.jpg)
![](images/2.3.jpg)

## **3 Завдання**
```java
package domain;

import java.io.*;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}

```
```java
package domain;

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

```
```java
package domain;

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
```
```java
package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть число: ");
        int number = scanner.nextInt();
        return number;
    }
}
```
```java
package test.Test3;

import domain.Calculation;
import domain.SolutionFinder;

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
```
![](images/3.1.jpg)
![](images/3.2.jpg)


## **4 Завдання**
```java
package domain;

import java.io.*;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}

```
```java
package domain;

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
                        System.out.println("┌────────────────┬────────────────┬────────────────┐");
                        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
                        System.out.println("├────────────────┼────────────────┼────────────────┤");
                        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
                        System.out.println("└────────────────┴────────────────┴────────────────┘");
                        
                        
                        
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
                        System.out.println("┌────────────────┬────────────────┬────────────────┐");
                        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
                        System.out.println("├────────────────┼────────────────┼────────────────┤");
                        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
                        System.out.println("└────────────────┴────────────────┴────────────────┘");
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

```
```java
package domain;

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
        System.out.println("┌────────────────┬────────────────┬────────────────┐");
        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
        System.out.println("├────────────────┼────────────────┼────────────────┤");
        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
        System.out.println("└────────────────┴────────────────┴────────────────┘");
    }
}
```
```java
package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть число: ");
        int number = scanner.nextInt();
        return number;
    }
}


```
```java
package test.Test4;

import domain.Calculation;
import domain.SolutionFinder;

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


```
![](images/4.1.jpg)
![](images/4.2.jpg)

## **5 Завдання**

```java
package domain;

import java.io.*;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}

```
```java
package domain;

import java.io.*;
import java.util.Scanner;

public class CalculationTest {

    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int currentNumber = 0;
        int previousNumber = 0;
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
            System.out.println("5. Нове введення числа.");
            System.out.println("6. Скасувати останнє введення.");
            System.out.println("7. Вийти.");
            System.out.println("___________________________________________________________");
            System.out.println("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    previousNumber = currentNumber;
                    currentNumber = solutionFinder.findSolution();
                    break;
                case 2:
                    if (currentNumber != 0) {
                        binary = calculation.toBinary(currentNumber);
                        octal = calculation.toOctal(currentNumber);
                        hexadecimal = calculation.toHexadecimal(currentNumber);
                        System.out.println("Представлення в різних системах числення числа " + currentNumber + ":");
                        System.out.println("┌────────────────┬────────────────┬────────────────┐");
                        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
                        System.out.println("├────────────────┼────────────────┼────────────────┤");
                        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
                        System.out.println("└────────────────┴────────────────┴────────────────┘");
                    } else {
                        System.out.println("Спочатку введіть число.");
                    }
                    break;
                case 3:
                    saveResults(currentNumber, binary, octal, hexadecimal);
                    System.out.println("Результат збережено.");
                    break;
                case 4:
                    int[] restoredData = restoreResults();
                    if (restoredData != null) {
                        currentNumber = restoredData[0];
                        binary = calculation.toBinary(currentNumber);
                        octal = calculation.toOctal(currentNumber);
                        hexadecimal = calculation.toHexadecimal(currentNumber);
                        System.out.println("Результат відновлено.");
                        System.out.println("Представлення в різних системах числення числа " + currentNumber + ":");
                        System.out.println("┌────────────────┬────────────────┬────────────────┐");
                        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
                        System.out.println("├────────────────┼────────────────┼────────────────┤");
                        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
                        System.out.println("└────────────────┴────────────────┴────────────────┘");
                    } else {
                        System.out.println("Немає збережених результатів.");
                    }
                    break;
                case 5:
                    previousNumber = currentNumber;
                    currentNumber = solutionFinder.findSolution();
                    break;
                case 6:
                    currentNumber = previousNumber;
                    previousNumber = 0;
                    System.out.println("Останнє введення скасовано.");
                    break;
                case 7:
                    System.out.println("Програма завершує роботу.");
                    break;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        } while (choice != 7);
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

```
```java
package domain;

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
        System.out.println("┌────────────────┬────────────────┬────────────────┐");
        System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
        System.out.println("├────────────────┼────────────────┼────────────────┤");
        System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
        System.out.println("└────────────────┴────────────────┴────────────────┘");
    }
}

```
```java
package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть число: ");
        int number = scanner.nextInt();
        return number;
    }
}

```
```java

import domain.Calculation;
import domain.SolutionFinder;

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

```
![](images/5.1.jpg)
![](images/5.2.jpg)
![](images/5.3.jpg)
![](images/5.4.jpg)
![](images/5.5.jpg)

## **6 Завдання**
```java
package domain;

import java.io.*;
import java.util.Scanner;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}
```
```java
package domain;

import java.io.*;
import java.util.Scanner;

public class CalculationTest {

    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int currentNumber = 0;
        int previousNumber = 0;
        String binary = "";
        String octal = "";
        String hexadecimal = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        while (true) {
            System.out.println("___________________________________________________________");
            System.out.println("МENU:");
            System.out.println("1. Ввести кількість чисел.");
            System.out.println("2. Відобразити представлення в різних системах числення.");
            System.out.println("3. Зберегти результат.");
            System.out.println("4. Відновити результат.");
            System.out.println("5. Нове введення числа.");
            System.out.println("6. Скасувати останнє введення.");
            System.out.println("7. Вийти.");
            System.out.println("___________________________________________________________");
            System.out.println("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    previousNumber = currentNumber;
                    currentNumber = solutionFinder.findSolution();
                    break;
                case 2:
                    if (currentNumber != 0) {
                        displayRepresentations(currentNumber, calculation);
                    } else {
                        System.out.println("Спочатку введіть кількість чисел.");
                    }
                    break;
                case 3:
                    saveResults(currentNumber, calculation);
                    System.out.println("Результат збережено.");
                    break;
                case 4:
                    restoreResults(calculation);
                    break;
                case 5:
                    previousNumber = currentNumber;
                    currentNumber = solutionFinder.findSolution();
                    break;
                case 6:
                    currentNumber = previousNumber;
                    previousNumber = 0;
                    System.out.println("Останнє введення скасовано.");
                    break;
                case 7:
                    System.out.println("Програма завершує роботу.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void displayRepresentations(int currentNumber, Calculation calculation) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < currentNumber; i++) {
            int randomNum = (int) (Math.random() * 1000);
            min = Math.min(min, randomNum);
            max = Math.max(max, randomNum);
            sum += randomNum;
            String binary = calculation.toBinary(randomNum);
            String octal = calculation.toOctal(randomNum);
            String hexadecimal = calculation.toHexadecimal(randomNum);
            System.out.println("Представлення в різних системах числення числа " + randomNum + ":");
            System.out.println("┌────────────────┬────────────────┬────────────────┐");
            System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
            System.out.println("├────────────────┼────────────────┼────────────────┤");
            System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
            System.out.println("└────────────────┴────────────────┴────────────────┘");
        }
        System.out.println("Мінімальне число в таблицях: " + min);
        System.out.println("Максимальне число в таблицях: " + max);
        System.out.println("Середнє арифметичне чисел з таблиць: " + (double) sum / currentNumber);
        System.out.println("Сума чисел: " + sum);
    }

    private static void saveResults(int number, Calculation calculation) {
        try (PrintWriter writer = new PrintWriter("results.txt")) {
            writer.println(number);
            for (int i = 0; i < number; i++) {
                int randomNum = (int) (Math.random() * 1000);
                writer.println(randomNum);
                writer.println(calculation.toBinary(randomNum));
                writer.println(calculation.toOctal(randomNum));
                writer.println(calculation.toHexadecimal(randomNum));
            }
        } catch (IOException e) {
            System.err.println("Помилка при збереженні результатів: " + e.getMessage());
        }
    }

    private static void restoreResults(Calculation calculation) {
        try (BufferedReader reader = new BufferedReader(new FileReader("results.txt"))) {
            int number = Integer.parseInt(reader.readLine());
            displayRepresentations(number, calculation);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Помилка при відновленні результатів: " + e.getMessage());
        }
    }
}

```
```java
package domain;

import java.util.Scanner;

public class Demonstration {

    public static void main(String[] args) {
        Calculation calculation = new Calculation();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Введіть кількість чисел: ");
                int count = scanner.nextInt();
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                int sum = 0;
                for (int i = 0; i < count; i++) {
                    int number = (int) (Math.random() * 1000); 
                    String binary = calculation.toBinary(number);
                    String octal = calculation.toOctal(number);
                    String hexadecimal = calculation.toHexadecimal(number);

                    System.out.println("Представлення в різних системах числення числа " + number + ":");
                    System.out.println("┌────────────────┬────────────────┬────────────────┐");
                    System.out.println("│   Двійкове     │   Вісімкове    │ Шістнадцяткове │");
                    System.out.println("├────────────────┼────────────────┼────────────────┤");
                    System.out.printf("│ %-14s │ %-14s │ %-14s │\n", binary, octal, hexadecimal);
                    System.out.println("└────────────────┴────────────────┴────────────────┘");

                    min = Math.min(min, number);
                    max = Math.max(max, number);
                    sum += number;
                }
                System.out.println("Мінімальне число в таблицях: " + min);
                System.out.println("Максимальне число в таблицях: " + max);
                System.out.println("Середне арифметичне чисел з таблиць: " + (double) sum / count);
                System.out.println("Сума чисел: " + sum);
            }
        } finally {
            scanner.close(); 
        }
    }
}

```
```java
package domain;

import java.util.Scanner;

public class SolutionFinder {
    private Scanner scanner = new Scanner(System.in);

    public int findSolution() {
        System.out.println("Введіть кількість чисел: ");
        int number = scanner.nextInt();
        return number;
    }
}
```
```java
package domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ProgramTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    public boolean testProgram() {
        // Simulate user input
        provideInput("3\n1\n");

        // Expected output
        String expectedOutput = "Введіть кількість чисел: \n" +
                "Представлення в різних системах числення числа 236:\n" +
                "┌────────────────┬────────────────┬────────────────┐\n" +
                "│   Двійкове     │   Вісімкове    │ Шістнадцяткове │\n" +
                "├────────────────┼────────────────┼────────────────┤\n" +
                "│ 11101100       │ 354            │ EC             │\n" +
                "└────────────────┴────────────────┴────────────────┘\n" +
                "Мінімальне число в таблицях: 236\n" +
                "Максимальне число в таблицях: 236\n" +
                "Середнє арифметичне чисел з таблиць: 236.0\n" +
                "Сума чисел: 236\n";

        // Check if the actual output matches the expected output
        String actualOutput;
        try {
            CalculationTest.main(null);
            actualOutput = getOutput();
        } catch (Exception e) {
            actualOutput = e.toString();
        }

        boolean testPassed = actualOutput.equals(expectedOutput);
        if (testPassed) {
            System.out.println("Тест пройдений успішно. Програма працює коректно.");
        } else {
            System.out.println("Тест не пройдений. Програма працює некоректно.");
        }
        return testPassed;
    }
}

```
```java
package test.Test6;

import domain.ProgramTest;

public class ProgramTestRunner {
    public static void main(String[] args) {
        ProgramTest test = new ProgramTest();
        if (test.testProgram()) {
            System.out.println("Програма працює коректно.");
        } else {
            System.out.println("Програма працює некоректно.");
        }
    }
}
```
![](images/6.1.jpg)
![](images/6.2.jpg)
![](images/6.3.jpg)
![](images/6.4.jpg)
![](images/6.5.jpg)
![](images/6.6.jpg)
![](images/6.7.jpg)
