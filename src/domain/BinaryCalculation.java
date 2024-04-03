package domain;

public class BinaryCalculation implements Calculation 
{
    @Override
    public String calculate(int number) 
    {
        return Integer.toBinaryString(number);
    }

    @Override
    public String generateTable(int number) 
    {
        StringBuilder table = new StringBuilder();
        table.append("Двійкова таблиця для ").append(number).append(":\n");
        table.append("Десяткова\tДвійкова\n");
        table.append(number).append("\t").append(calculate(number)).append("\n");
        return table.toString();
    }
}
