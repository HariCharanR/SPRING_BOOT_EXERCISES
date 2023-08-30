package com.solutions.day6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.day6.model.BabyModel;

public interface BabyRepo extends JpaRepository<BabyModel,Integer> {
	
}
