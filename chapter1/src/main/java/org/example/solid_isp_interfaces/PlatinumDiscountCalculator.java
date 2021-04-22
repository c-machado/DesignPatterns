package org.example.solid_isp_interfaces;

public class PlatinumDiscountCalculator implements DiscountCalculator {

    public double calculateRegularDiscount(double totalPrice) {
        return (totalPrice) - 100;
    }

    public double calculateBonusPointsDiscount(double totalPrice, int points) throws NoSuchMethodException {
        throw new NoSuchMethodException("not applicable for platinum users");
    }
}
