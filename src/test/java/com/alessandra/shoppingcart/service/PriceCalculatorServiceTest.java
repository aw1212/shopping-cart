package com.alessandra.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.alessandra.shoppingcart.Apple;
import com.alessandra.shoppingcart.Fruit;
import com.alessandra.shoppingcart.Offer;
import com.alessandra.shoppingcart.Orange;
import com.alessandra.shoppingcart.ShoppingCart;
import com.google.common.collect.ImmutableList;

public class PriceCalculatorServiceTest {

    private static final double DELTA = 0.0001;
    private ShoppingCart shoppingCart;
    private PriceCalculatorService priceCalculatorService = new PriceCalculatorService();

    @Before
    public void init() {
        final List<Fruit> fruit = new ArrayList<>();
        List<Apple> apples = ImmutableList.of(new Apple(), new Apple(), new Apple());
        List<Orange> oranges = ImmutableList.of(new Orange(), new Orange(), new Orange(), new Orange());
        fruit.addAll(apples);
        fruit.addAll(oranges);
        shoppingCart = new ShoppingCart(fruit);
    }

    @Test
    public void givenListOfApplesAndOrangesWithBothOffers_whenCalculatingCosts_thenTotalCostIsCalculated() {
        List<Offer> offers = ImmutableList.of(Offer.BUY_ONE_GET_ONE_FREE_APPLES, Offer.THREE_FOR_TWO_ORANGES);
        double totalCost = priceCalculatorService.calculateTotalCost(shoppingCart, offers);

        assertEquals(1.95, totalCost, DELTA);
    }

    @Test
    public void givenListOfApplesAndOrangesWithNoOffers_whenCalculatingCosts_thenTotalCostIsCalculated() {
        double totalCost = priceCalculatorService.calculateTotalCost(shoppingCart, new ArrayList<>());

        assertEquals(2.8, totalCost, DELTA);
    }

    @Test
    public void givenListOfApplesAndOrangesWithAppleOffer_whenCalculatingCosts_thenTotalCostIsCalculated() {
        List<Offer> offers = ImmutableList.of(Offer.BUY_ONE_GET_ONE_FREE_APPLES);
        double totalCost = priceCalculatorService.calculateTotalCost(shoppingCart, offers);

        assertEquals(2.2, totalCost, DELTA);
    }

    @Test
    public void givenListOfApplesAndOrangesWithOrangeOffer_whenCalculatingCosts_thenTotalCostIsCalculated() {
        List<Offer> offers = ImmutableList.of(Offer.THREE_FOR_TWO_ORANGES);
        double totalCost = priceCalculatorService.calculateTotalCost(shoppingCart, offers);

        assertEquals(2.55, totalCost, DELTA);
    }


}
