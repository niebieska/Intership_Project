package com.softsystem.clinic.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;

@Repository
public interface ReceptionRepository extends CrudRepository<Reception, Integer> {
	
	public Reception findById(int id);

}
