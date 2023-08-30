package com.solutions.Toy_store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.Toy_store.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
