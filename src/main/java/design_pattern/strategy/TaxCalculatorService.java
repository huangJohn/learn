package design_pattern.strategy;

public class TaxCalculatorService {

    final double salary;

    final double bonus;

    private TaxCalculateStrategy taxCalculateStrategy;


    public TaxCalculatorService(double salary, double bonus, TaxCalculateStrategy taxCalculateStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.taxCalculateStrategy = taxCalculateStrategy;
    }

//    private double calculateTax() {
//        return this.getSalary() * SALARY_RATE+ this.getBonus() * BONUS_RATE;
//    }

    public double yourTax() {
        return calculateTax();
    }

    private double calculateTax() {
        return this.taxCalculateStrategy.calculateTax(getSalary(), getBonus());
    }

    private double getSalary() {
        return salary;
    }

    private double getBonus() {
        return bonus;
    }

//    public void setTaxCalculateStrategy(TaxCalculateStrategy taxCalculateStrategy) {
//        this.taxCalculateStrategy = taxCalculateStrategy;
//    }
}
