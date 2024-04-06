package domain;
public class Demo 
{
    public static void main(String[] args) {
        SolutionFinder solutionFinder = new SolutionFinder();
        int number = solutionFinder.findSolution();

        Calculation calculation = new Calculation();
        String result = "";

        int choice = solutionFinder.chooseAction();

        switch (choice) {
            case 1:
                result = calculation.toBinary(number);
                break;
            case 2:
                result = calculation.toOctal(number);
                break;
            case 3:
                result = calculation.toHexadecimal(number);
                break;
            case 4:
                String[] results = {calculation.toBinary(number), calculation.toOctal(number), calculation.toHexadecimal(number)};
                SerializationManager.serializeResults(results);
                return;
            case 5:
                String[] deserializedResults = SerializationManager.deserializeResults();
                if (deserializedResults != null) {
                    System.out.println("Двійкове представлення: " + deserializedResults[0]);
                    System.out.println("Вісімкове представлення: " + deserializedResults[1]);
                    System.out.println("Шістнадцяткове представлення: " + deserializedResults[2]);
                }
                return;
            default:
                System.out.println("Некоректний вибір дії.");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
