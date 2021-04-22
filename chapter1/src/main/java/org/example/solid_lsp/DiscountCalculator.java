package org.example.solid_lsp;


public abstract class DiscountCalculator {
    public double calculateRegularDiscount(double totalPrice) {
        return totalPrice;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) throws NoSuchMethodException {
        return totalPrice - points * 0.1;
    }
}
