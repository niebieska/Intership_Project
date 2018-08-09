package com.softsystem.clinic.project.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.utils.PasswordEncoder;

@Service
public class PatientServiceImpl implements PatientService{
	
	Logger logger = (Logger) LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private PatientRepository patientRepository;
	
		
	@Override
	public String add(String pat_Mrn,String pat_Fname, String pat_Lname, String pat_Mname, Date pat_Dob, String pat_Sex, String pat_Email, String pat_Passhash, int pat_Phone, boolean pat_Confirmation){
		Patient patient = new Patient();
		
		Iterable<Patient> findAll = patientRepository.findAll();
		
		patient.setPat_Dob(pat_Dob);
		patient.setPatEmail(pat_Email);
		patient.setPat_Fname(pat_Fname);
		patient.setPat_Lname(pat_Lname);
		patient.setPat_Mname(pat_Mname);
		patient.setPat_Mrn(pat_Mrn);
		patient.setPat_Passhash(PasswordEncoder.encodePass(pat_Passhash));
		patient.setPat_Sex(pat_Sex);
		patient.setPat_Phone(pat_Phone);
		patient.setPat_Confirmation(pat_Confirmation);
		patientRepository.save(patient);		
		
		return "patient added";
		
	}
	
	@Override
	public void deleteOnePatient(int id) {
		patientRepository.deleteById(id);
		
	}

	@Override
	public List<Patient> listOfPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Patient> findOnePatient(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
