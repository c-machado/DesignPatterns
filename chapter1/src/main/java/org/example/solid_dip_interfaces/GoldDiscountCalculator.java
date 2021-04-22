package org.example.org.example.solid_dip_interfaces;

public class GoldDiscountCalculator implements BonusPointsDiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return totalPrice - 50;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 1;
    }
}
