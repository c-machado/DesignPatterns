package org.example.solid_isp_interfaces;

public class GoldDiscountCalculator implements DiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return totalPrice - 50;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 1;
    }
}
