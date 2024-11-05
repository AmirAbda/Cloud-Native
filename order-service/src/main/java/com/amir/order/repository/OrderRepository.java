package com.amir.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amir.order.model.Order;

public interface OrderRepository extends JpaRepository<Order , Long>  {

    }
