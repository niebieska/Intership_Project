package com.softsystem.clinic.project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;

@Repository
public interface ReceptionRepository extends CrudRepository<Reception, Integer> {
	
	public Reception findById(int id);
	
	@Query("select r from Reception r where r.recEmail=:recEmail")
	public Reception findByRecEmail(@Param("recEmail")String recEmail);

}
