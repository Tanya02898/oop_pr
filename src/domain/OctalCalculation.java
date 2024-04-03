package domain;

public class OctalCalculation implements Calculation 
{
    @Override
    public String calculate(int number) 
    {
        return Integer.toOctalString(number);
    }

    @Override
    public String generateTable(int number) 
    {
        StringBuilder table = new StringBuilder();
        table.append("Вісімкова таблиця для ").append(number).append(":\n");
        table.append("Десяткова\tВісімкова\n");
        table.append(number).append("\t").append(calculate(number)).append("\n");
        return table.toString();
    }
}
