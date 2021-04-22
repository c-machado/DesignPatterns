package org.example.org.example.solid_lsp_interfaces;

public class PlatinumDiscountCalculator implements BonusPointsDiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return (totalPrice) - 100;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) throws NoSuchMethodException {
        throw new NoSuchMethodException("not applicable for platinum users");
    }
}
