package com.softsystem.clinic.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.softsystem.clinic.project.model.Patient;


public interface PatientRepository extends CrudRepository<Patient,Integer> {

	public Patient findById(int id);
	public Patient findByPatEmail(String pat_Email);

}
