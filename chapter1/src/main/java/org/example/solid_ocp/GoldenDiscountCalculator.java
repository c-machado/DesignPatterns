package org.example.org.example.solid_ocp;

public class GoldenDiscountCalculator extends DiscountCalculatorOCP {
    @Override
    public double calculateDiscount(double totalPrice) {
        return super.calculateDiscount(totalPrice) - 50;
    }
}
