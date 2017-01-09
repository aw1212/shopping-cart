package com.alessandra.shoppingcart;

public enum Offer {
    BUY_ONE_GET_ONE_FREE_APPLES("Buy one get one free one apples"),
    THREE_FOR_TWO_ORANGES("Three for two on oranges");

    private String offerName;

    Offer(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferName() {
        return offerName;
    }
}
