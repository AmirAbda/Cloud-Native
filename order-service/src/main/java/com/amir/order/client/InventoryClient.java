package com.amir.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="inventory",url="http://localhost:8082")
public interface InventoryClient {
    @GetMapping("/api/inventory")
    boolean isInStock(@RequestParam String skiCode, @RequestParam Integer quantity);
}