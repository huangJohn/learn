package design_pattern.strategy;

public class TaxCalculateStrategyImpl implements TaxCalculateStrategy {

    @Override
    public double calculateTax(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
