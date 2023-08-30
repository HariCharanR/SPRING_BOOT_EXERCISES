package com.solutions.day7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.day7.model.CarModel;
import com.solutions.day7.repository.CarRepo;

@Service
public class CarService {
	@Autowired
	CarRepo cr;
	
	public CarModel save(CarModel data) {
		return cr.save(data);
	}
	
	public List<CarModel> getByOwn(int own){
		return cr.getCarFromOwners(own);
	}
	
	public List<CarModel> getByAddr(String addr){
		return cr.getCarFromAddress(addr);
	}
	
	public List<CarModel> getByName(String name){
		return cr.getCarFromName(name);
	}
	
	public List<CarModel> getBoth(int own , String type){
		return cr.getCarfromOwnerct(own, type);
	}
	
	

}
