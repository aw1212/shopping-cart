package com.alessandra.shoppingcart;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private final List<Fruit> fruitList;

    public ShoppingCart(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public List<Apple> getApples() {
        return fruitList.stream()
                .filter(fruit -> fruit.getName().equals("apple"))
                .map(fruit -> (Apple) fruit)
                .collect(Collectors.toList());
    }

    public List<Orange> getOranges() {
        return fruitList.stream()
                .filter(fruit -> fruit.getName().equals("orange"))
                .map(fruit -> (Orange) fruit)
                .collect(Collectors.toList());
    }

}
