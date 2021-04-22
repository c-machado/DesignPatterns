package main;

import org.example.solid_isp_interfaces.DiscountCalculator;
import org.example.solid_isp_interfaces.GoldDiscountCalculator;
import org.example.solid_isp_interfaces.SilverDiscountCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTestsIsp {

    @Test
    public void createDiscountWithInterfaces() throws NoSuchMethodException {
        List<DiscountCalculator> discountCalculators = new ArrayList<>();
        discountCalculators.add(new SilverDiscountCalculator());
        discountCalculators.add(new GoldDiscountCalculator());
//        discountCalculators.add(new PlatinumDiscountCalculator()); //we cannot add it
        for (var discountCalculator : discountCalculators) {
            double bonusPointsDiscount = discountCalculator.calculateBonusPointsDiscount(1250, 10);
            System.out.println("testing " + bonusPointsDiscount);
        }
    }
}