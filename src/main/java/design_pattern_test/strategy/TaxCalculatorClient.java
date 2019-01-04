package design_pattern_test.strategy;

public class TaxCalculatorClient {

    public static void main(String[] args) {


        TaxCalculatorService service = new TaxCalculatorService(2000d, 1000d, new TaxCalculateStrategy() {
            @Override
            public double calculateTax(double salary, double bonus) {
                return salary * SALARY_RATE + bonus * BONUS_RATE;
            }
        });
//        TaxCalculateStrategy strategy = new TaxCalculateStrategyImpl();
//        service.setTaxCalculateStrategy(strategy);
        System.out.println(service.yourTax());


        TaxCalculatorService service2 = new TaxCalculatorService(20000d, 10000d, (salary, bonus) -> salary * 1.0d + bonus * 1.5d);
        System.out.println(service2.yourTax());
    }

}
