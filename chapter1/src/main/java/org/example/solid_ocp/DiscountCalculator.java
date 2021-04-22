package org.example.org.example.solid_ocp;

public class DiscountCalculator {

    //if we add new order types, we will have to add more IF conditions, and also DiscountCalculator needs to change,
    // so instead of this, we create a new class per each order type
    public double calculateDiscount(OrderType orderType, double totalPrice) {
        if (orderType == OrderType.Silver) {
            return totalPrice - 20;
        } else {
            return totalPrice;
        }
    }
}
