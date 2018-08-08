package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;

import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Schedule;

public interface ScheduleService {

	public String add(Date sch_Starthour, Date sch_Endhour, Doctor doctorCode);

	public void deleteOneSchedule(int id); 
	
	public List<Schedule> listOfSchedules(); 
	
}
