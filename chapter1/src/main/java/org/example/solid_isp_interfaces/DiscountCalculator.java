package org.example.solid_isp_interfaces;

public interface DiscountCalculator {

    double calculateRegularDiscount(double totalPrice);

    double calculateBonusPointsDiscount(double totalPrice, int points) throws NoSuchMethodException;

}
