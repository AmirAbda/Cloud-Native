package com.amir.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.amir.order.client.InventoryClient;
import com.amir.order.dto.OrderRequest;
import com.amir.order.model.Order;
import com.amir.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

        private final OrderRepository orderRepository;
        private final InventoryClient inventoryClient;
        public void placeOrder(OrderRequest orderRequest) {
            var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
            
            if (isProductInStock) {
                Order order = new Order();
                order.setOrderNumber(UUID.randomUUID().toString());
                order.setPrice(orderRequest.price());
                order.setSkuCode(orderRequest.skuCode());
                order.setQuantity(orderRequest.quantity());
                orderRepository.save(order);
        }else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock");
        }
    
}
}
