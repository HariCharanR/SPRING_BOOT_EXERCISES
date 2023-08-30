package com.solutions.Toy_store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.Toy_store.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
