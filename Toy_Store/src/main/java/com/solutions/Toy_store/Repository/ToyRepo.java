package com.solutions.Toy_store.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.Toy_store.Model.Toy;

public interface ToyRepo extends JpaRepository<Toy,Integer>{

}
