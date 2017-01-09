package com.alessandra.shoppingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.alessandra.shoppingcart.Apple;
import com.alessandra.shoppingcart.Offer;
import com.alessandra.shoppingcart.Orange;
import com.alessandra.shoppingcart.ShoppingCart;

@Service
public class PriceCalculatorService {

    public double calculateTotalCost(ShoppingCart shoppingCart, List<Offer> offers) {
        double orangeCost = calculateCostOfOranges(shoppingCart.getOranges(), offers);
        double appleCost = calculateCostOfApples(shoppingCart.getApples(), offers);
        return orangeCost + appleCost;
    }

    private double calculateCostOfOranges(List<Orange> oranges, List<Offer> offers) {
        if (oranges == null) {
            return 0.0;
        }
        double price = oranges.get(0).getPrice();
        if (!offers.contains(Offer.THREE_FOR_TWO_ORANGES)) {
            return oranges.size() * price;
        }

        int freeOranges = oranges.size() / 3;
        return (oranges.size() - freeOranges) * price;
    }

    private double calculateCostOfApples(List<Apple> apples, List<Offer> offers) {
        if (apples == null) {
            return 0.0;
        }
        double price = apples.get(0).getPrice();
        if (!offers.contains(Offer.BUY_ONE_GET_ONE_FREE_APPLES)) {
            return apples.size() * price;
        }

        int freeApples = apples.size() / 2;
        return (apples.size() - freeApples) * price;
    }

}
