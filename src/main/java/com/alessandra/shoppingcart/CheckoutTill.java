package com.alessandra.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alessandra.shoppingcart.service.PriceCalculatorService;
import com.google.common.collect.ImmutableList;

@SpringBootApplication
public class CheckoutTill implements CommandLineRunner {

    private static final int NUM_APPLES = 3;
    private static final int NUM_ORANGES = 5;
    private static final List<Offer> OFFERS = ImmutableList.of(Offer.BUY_ONE_GET_ONE_FREE_APPLES, Offer.THREE_FOR_TWO_ORANGES);

    @Autowired
    private PriceCalculatorService priceCalculatorService;

    public static void main(String[] args) {
        SpringApplication.run(CheckoutTill.class, args);
    }

    @Override
    public void run(String... args) {
        List<Fruit> fruit = new ArrayList<>();
        for (int i = 0; i < NUM_APPLES; i++) {
            fruit.add(new Apple());
        }
        for (int i = 0; i < NUM_ORANGES; i++) {
            fruit.add(new Orange());
        }
        ShoppingCart shoppingCart = new ShoppingCart(fruit);
        String currentOffers = OFFERS.stream()
                .map(Offer::getOfferName)
                .collect(Collectors.joining("\n"));
        double totalCost = priceCalculatorService.calculateTotalCost(shoppingCart, OFFERS);
        System.out.println("CURRENT OFFERS:\n" + currentOffers + "\nTOTAL COST: " + totalCost);
    }

}
