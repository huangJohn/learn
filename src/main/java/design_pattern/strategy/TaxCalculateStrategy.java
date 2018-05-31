package design_pattern.strategy;

public interface TaxCalculateStrategy {
    double SALARY_RATE = 2d;
    double BONUS_RATE = 3.5d;
    double calculateTax(double salary, double bonus);
}
