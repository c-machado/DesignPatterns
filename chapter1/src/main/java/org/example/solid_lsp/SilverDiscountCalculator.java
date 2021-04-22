package org.example.solid_lsp;

public class SilverDiscountCalculator extends DiscountCalculator {


    @Override
    // reuse the logic defined in the base class using the keyword 'super'
    public double calculateRegularDiscount(double totalPrice) {
        return super.calculateRegularDiscount(totalPrice) - 20;
    }

    @Override
    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 0.5;
    }

}
