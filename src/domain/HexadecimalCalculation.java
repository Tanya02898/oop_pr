package domain;

public class HexadecimalCalculation implements Calculation 
{
    @Override
    public String calculate(int number) 
    {
        return Integer.toHexString(number);
    }

    @Override
    public String generateTable(int number) 
    {
        StringBuilder table = new StringBuilder();
        table.append("Шістнадцяткова таблиця для ").append(number).append(":\n");
        table.append("Десяткова\tШістнадцяткова\n");
        table.append(number).append("\t").append(calculate(number)).append("\n");
        return table.toString();
    }
}
