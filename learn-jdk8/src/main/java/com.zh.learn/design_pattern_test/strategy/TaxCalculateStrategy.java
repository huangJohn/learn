package com.zh.learn.design_pattern_test.strategy;

public interface TaxCalculateStrategy {
    double SALARY_RATE = 2d;
    double BONUS_RATE = 3.5d;
    double calculateTax(double salary, double bonus);
}
