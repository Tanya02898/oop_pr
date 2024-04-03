package domain;
public class Demonstration 
{

    public static void main(String[] args) 
    {
        SolutionFinder solutionF = new SolutionFinder();
        int number = solutionF.findSolution();

        // Вибір типу обчислення
        System.out.println("Обчислення в різних системах числення:");

        CalculationFactory binFactory = new BinaryCalculationFactory();
        Calculation binC = binFactory.createCalculation();
        String binaryResult = binC.calculate(number);

        CalculationFactory octFactory = new OctalCalculationFactory();
        Calculation octC = octFactory.createCalculation();
        String octalResult = octC.calculate(number);

        CalculationFactory hexFactory = new HexadecimalCalculationFactory();
        Calculation hexC = hexFactory.createCalculation();
        String hexadecimalResult = hexC.calculate(number);

        // Виведення таблиці
        System.out.println("Таблиця обчислень:");
        System.out.println("Двійкова\t" + binaryResult);
        System.out.println("Вісімкова\t" + octalResult);
        System.out.println("Шістнадцяткова\t" + hexadecimalResult);
    }
}
