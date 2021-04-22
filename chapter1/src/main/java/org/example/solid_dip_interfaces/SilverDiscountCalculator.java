package org.example.org.example.solid_dip_interfaces;

public class SilverDiscountCalculator implements BonusPointsDiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return totalPrice - 20;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 0.5;
    }

}
