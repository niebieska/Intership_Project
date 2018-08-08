package com.softsystem.clinic.project.services;

import java.util.List;

import com.softsystem.clinic.project.model.Doctor;

public interface DoctorService {
	public String add(String getDoc_Spec);

	public void deleteOneDoctor(String id);

	public List<Doctor> listOfDoctors();
}
