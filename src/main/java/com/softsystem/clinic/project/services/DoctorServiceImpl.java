package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softsystem.clinic.project.dao.DoctorRepository;
import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Patient;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public String add(String doc_Spec) {
			Doctor doctor=new Doctor();
			doctor.setDoc_Spec(doc_Spec);
			doctorRepository.save(doctor);
			return "doctor added";
	}

	
	public void deleteOneDoctor(String id) {
		 doctorRepository.deleteById(id);
	}
	@Override
	public List<Doctor> listOfDoctors() {
		return (List<Doctor>) doctorRepository.findAll();
	}
	
}
