package com.alessandra.shoppingcart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alessandra.shoppingcart.service.PriceCalculatorService;
import com.google.common.collect.ImmutableList;

@SpringBootApplication
public class ShoppingCart implements CommandLineRunner {

    @Autowired
    private PriceCalculatorService priceCalculatorService;

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCart.class, args);
    }

    @Override
    public void run(String... args) {
        Apple apple = new Apple();
        Orange orange = new Orange();
        List<Fruit> fruitList = ImmutableList.of(apple, orange);
        System.out.println("total price: " + priceCalculatorService.calculateTotalCost(fruitList));
    }

}
