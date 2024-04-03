package domain;

public class BinaryCalculationFactory implements CalculationFactory 
{
    @Override
    public Calculation createCalculation() 
    {
        return new BinaryCalculation();
    }
}
