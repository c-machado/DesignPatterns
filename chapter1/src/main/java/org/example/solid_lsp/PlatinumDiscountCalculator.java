package org.example.solid_lsp;

public class PlatinumDiscountCalculator extends DiscountCalculator {
    @Override
    public double calculateRegularDiscount(double totalPrice) {
        return super.calculateRegularDiscount(totalPrice) - 100;
    }

    //based on polymorphism, we can use any of the child classes calculators derived from the DiscountCalculator,
    // as if they are the actual DiscountCalculator class
    @Override
    public double calculateBonusPointsDiscount(double totalPrice, int points) throws NoSuchMethodException {
        throw new NoSuchMethodException("not applicable for platinum users");
    }
}
