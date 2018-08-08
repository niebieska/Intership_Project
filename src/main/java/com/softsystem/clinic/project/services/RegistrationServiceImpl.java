package com.softsystem.clinic.project.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.validator.RegistrationViewModel;


@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	PatientRepository patientRepository;
	
	 public void registration(RegistrationViewModel registrationViewModel){
	        Patient patient = new Patient();
	        
	        patient.setPat_Mrn(registrationViewModel.getPat_Mrn());
	        patient.setPat_Fname(registrationViewModel.getPat_Fname());
	        patient.setPat_Mname(registrationViewModel.getPat_Mname());
	        patient.setPat_Lname(registrationViewModel.getPat_Lname());
	        patient.setPat_Sex(registrationViewModel.getPat_Sex());
	        patient.setPat_Passhash(registrationViewModel.getPat_Passhash());
	        patient.setPat_Email(registrationViewModel.getPat_Email());
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	        Date date;
			try {
				date = dateFormat.parse(registrationViewModel.getPat_Dob());
				patient.setPat_Dob(new java.sql.Timestamp((date).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        patientRepository.save(patient);

	        
	    }
}
