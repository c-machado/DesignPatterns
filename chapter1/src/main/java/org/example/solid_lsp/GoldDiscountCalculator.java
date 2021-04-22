package org.example.solid_lsp;

public class GoldDiscountCalculator extends DiscountCalculator {
    @Override
    public double calculateRegularDiscount(double totalPrice) {
        return super.calculateRegularDiscount(totalPrice) - 50;
    }

    @Override
    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 1;
    }
}
