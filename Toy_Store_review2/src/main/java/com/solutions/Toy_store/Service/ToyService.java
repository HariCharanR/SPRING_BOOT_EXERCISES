package com.solutions.Toy_store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
			return t.findAll(Sort.by(Sort.Direction.ASC,"name"));
		}
		public List<Toy> fetchByMname(String name){
			return t.findrecordByMname(name);
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
		
		public List<Toy> fetch_by_batch(int pno, int psize){
			PageRequest page = PageRequest.of(pno, psize,Sort.by(Sort.Direction.ASC,"name"));
			return t.findAll(page).getContent();
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
