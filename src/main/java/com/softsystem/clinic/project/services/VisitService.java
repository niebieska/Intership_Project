package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;

import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.model.Visit;

public interface VisitService {
	
	public String add(String vis_Presc, String vis_Doc_Id, Date vis_Reg_Date, Date vis_Dis_Date, int vis_Room, boolean vis_Confirmation, Reception receptionId, Patient patientId, Schedule scheduleId);

	public void deleteOneVisit(int id); 
	
	public List<Visit> listOfVisits(); 
}
