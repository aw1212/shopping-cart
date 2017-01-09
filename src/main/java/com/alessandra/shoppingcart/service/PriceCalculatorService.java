package com.alessandra.shoppingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.alessandra.shoppingcart.Fruit;

@Service
public class PriceCalculatorService {

    public double calculateTotalCost(List<Fruit> fruitList) {
        return fruitList.stream()
                .mapToDouble(Fruit::getPrice)
                .sum();
    }

}
