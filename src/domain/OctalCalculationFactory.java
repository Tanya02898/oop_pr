package domain;

public class OctalCalculationFactory implements CalculationFactory 
{
    @Override
    public Calculation createCalculation() 
    {
        return new OctalCalculation();
    }
}
