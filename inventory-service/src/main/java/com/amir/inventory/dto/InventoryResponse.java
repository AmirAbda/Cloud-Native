package com.amir.inventory.dto;

public record InventoryResponse(

    String skuCode,
    boolean isInStock
) {

}
