package com.solutions.Toy_store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.Toy_store.Model.Toy;
import com.solutions.Toy_store.Repository.ToyRepo;

@Service
public class ToyService {
		
	
		@Autowired
		ToyRepo t;
		
		public Toy createToy(Toy toy) {
			if(t.existsById(toy.getId())) {
				return null;
			}
			return t.save(toy);
		}
		
		public List<Toy> fetchAllToy(){
			return t.findAll();
		}
		
		public Toy fetchToy(int id) {
			return t.findById(id).orElse(null);
		}
		public Toy updateToy(Toy toy) {
			if(t.existsById(toy.getId())) {
				return t.save(toy);				
			}
			return null;
		}
		
		public boolean deleteToy(int id) {
			if(t.existsById(id)) {
				t.deleteById(id);
				return true;
			}else {
				return false;
			}
		}
}
