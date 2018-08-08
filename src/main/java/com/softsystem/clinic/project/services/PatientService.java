package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.softsystem.clinic.project.model.Patient;

public interface PatientService {
	//public boolean add(Patient patientDAO);

	public void deleteOnePatient(int id); 
	
	public List<Patient> listOfPatients(); 
	
	public Optional<Patient> findOnePatient(int id);

	String add(String pat_Mrn, String pat_Fname, String pat_Lname, String pat_Mname, Date pat_Dob, String pat_Sex,
			String pat_Email, String pat_Passhash, int pat_Phone, boolean pat_Confirmation);
}
