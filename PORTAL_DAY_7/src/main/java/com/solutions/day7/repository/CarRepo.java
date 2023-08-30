package com.solutions.day7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solutions.day7.model.CarModel;

public interface CarRepo extends JpaRepository<CarModel,Integer> {
		@Query(value="select * from Cars where owners=:own" , nativeQuery = true)
		public List<CarModel> getCarFromOwners(@Param("own") int own);
		
		@Query(value="select * from Cars where address=:addr",nativeQuery = true)
		public List<CarModel> getCarFromAddress(@Param("addr") String address);
		
		@Query(value="select * from Cars where car_name=:namec",nativeQuery = true)
		public List<CarModel> getCarFromName(@Param("namec") String carname);
		
		@Query(value="select * from Cars where owners=:own and car_type=:ct",nativeQuery = true)
		public List<CarModel> getCarfromOwnerct(@Param("own") int owner , @Param("ct") String ctype);


}
