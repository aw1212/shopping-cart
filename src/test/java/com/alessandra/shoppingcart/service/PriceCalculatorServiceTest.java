package com.alessandra.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import com.alessandra.shoppingcart.Apple;
import com.alessandra.shoppingcart.Fruit;
import com.alessandra.shoppingcart.Orange;
import com.google.common.collect.ImmutableList;

public class PriceCalculatorServiceTest {

    private static final double DELTA = 0.0001;
    private PriceCalculatorService priceCalculatorService = new PriceCalculatorService();

    @Test
    public void givenListOfFruit_whenCalculatingCosts_thenTotalCostIsCalculated() {
        List<Fruit> fruitList = ImmutableList.of(new Apple(), new Apple(), new Orange(), new Apple());
        double totalCost = priceCalculatorService.calculateTotalCost(fruitList);

        assertEquals(2.05, totalCost, DELTA);
    }

}
