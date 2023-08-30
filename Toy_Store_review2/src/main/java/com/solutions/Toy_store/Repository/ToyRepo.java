package com.solutions.Toy_store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.solutions.Toy_store.Model.Toy;

public interface ToyRepo extends JpaRepository<Toy,Integer>{
		@Query(value="select * from toys where manufacturer=:mname", nativeQuery = true)
		public List<Toy> findrecordByMname(@Param("mname") String mname);
}
