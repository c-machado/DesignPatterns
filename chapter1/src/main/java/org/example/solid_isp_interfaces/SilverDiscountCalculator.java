package org.example.solid_isp_interfaces;

public class SilverDiscountCalculator implements DiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return totalPrice - 20;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) {
        return totalPrice - points * 0.5;
    }

}
