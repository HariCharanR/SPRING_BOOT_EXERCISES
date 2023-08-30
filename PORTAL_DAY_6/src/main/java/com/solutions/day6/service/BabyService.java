package com.solutions.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.solutions.day6.model.BabyModel;
import com.solutions.day6.repository.BabyRepo;

@Service
public class BabyService {
		@Autowired
		BabyRepo br;
		
		public BabyModel createBaby(BabyModel b) {
			return br.save(b);
		}
		
		public List<BabyModel> fetchAllBabies() {
			return br.findAll();
		}
		
		public List<BabyModel> fetchBabyInSorted(String s){
			return br.findAll(Sort.by(Sort.Direction.ASC,s));
		}
		
		public List<BabyModel> fetchByBatch(int pno , int psize){
			Page<BabyModel> p = br.findAll(PageRequest.of(pno, psize));
			return p.getContent();
		}
		
		public void deleteBaby(int id) {
			br.deleteById(id);
		}
		
		public List<BabyModel> fetchByBatchSorted(String s , int pno , int psize){
			PageRequest page = PageRequest.of(pno, psize,Sort.by(Sort.Direction.ASC,s));
			return  br.findAll(page).getContent();
			
		}
	
}
