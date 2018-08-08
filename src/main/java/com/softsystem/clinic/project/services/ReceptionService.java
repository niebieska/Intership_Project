package com.softsystem.clinic.project.services;

import java.util.List;

import com.softsystem.clinic.project.model.Reception;

public interface ReceptionService {
	public String add(String rec_FName, String rec_LName, int rec_PhoneEnum);

	public void deleteOneReception(int id); 
	
	public List<Reception> listOfReceptions(); 
}
