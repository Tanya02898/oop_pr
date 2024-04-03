package domain;

public class HexadecimalCalculationFactory implements CalculationFactory 
{
    @Override
    public Calculation createCalculation() 
    {
        return new HexadecimalCalculation();
    }
}
