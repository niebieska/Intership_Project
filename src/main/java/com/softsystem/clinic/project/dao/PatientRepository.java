package com.softsystem.clinic.project.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softsystem.clinic.project.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Integer> {

	public Patient findById(int id);
	public Patient findByPatEmail(String pat_Email);

}
