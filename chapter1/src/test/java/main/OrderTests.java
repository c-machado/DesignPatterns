package main;

import org.example.solid_lsp.DiscountCalculator;
import org.example.solid_lsp.GoldDiscountCalculator;
import org.example.solid_lsp.SilverDiscountCalculator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTests {

    @Test
    public void createDiscountWithoutInterfaces() throws NoSuchMethodException {
        List<DiscountCalculator> discountCalculators = new ArrayList<>();
        discountCalculators.add(new SilverDiscountCalculator());
        discountCalculators.add(new GoldDiscountCalculator());
//        discountCalculators.add(new PlatinumDiscountCalculator());
        for (var discountCalculator : discountCalculators) {
            double bonusPointsDiscount = discountCalculator.calculateBonusPointsDiscount(1250, 10);
            System.out.println(bonusPointsDiscount);
            System.out.println(discountCalculator);
        }
    }


}