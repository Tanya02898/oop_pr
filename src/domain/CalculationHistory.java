package domain;

import java.util.HashMap;
import java.util.Map;

public class CalculationHistory 
{
    private Map<Integer, String> history = new HashMap<>();

    public void addToHistory(int number, String result) 
    {
        history.put(number, result);
    }

    public String getFromHistory(int number) 
    {
        return history.get(number);
    }

    public boolean isInHistory(int number) 
    {
        return history.containsKey(number);
    }
}
