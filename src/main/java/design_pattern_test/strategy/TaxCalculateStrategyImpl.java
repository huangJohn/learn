package design_pattern_test.strategy;

public class TaxCalculateStrategyImpl implements TaxCalculateStrategy {

    @Override
    public double calculateTax(double salary, double bonus) {
        return salary * SALARY_RATE + bonus * BONUS_RATE;
    }
}
