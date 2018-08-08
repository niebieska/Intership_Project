package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softsystem.clinic.project.dao.VisitRepository;
import com.softsystem.clinic.project.model.Doctor;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.model.Visit;

@Service
public class VisitServiceImpl implements VisitService {
	
	@Autowired
	private VisitRepository visitRepository;
	
	@Override
	public String add(String vis_Presc, String vis_Doc_Id, Date vis_Reg_Date, Date vis_Dis_Date, int vis_Room, boolean vis_Confirmation, Reception receptionId, Patient patientId, Schedule scheduleId) {
		Visit visit=new Visit();
		visit.setVis_Dis_Date(vis_Dis_Date);
		visit.setVis_Confirmation(vis_Confirmation);
		visit.setVis_Doc_Id(vis_Doc_Id);
		visit.setVis_Presc(vis_Presc);
		visit.setVis_Reg_Date(vis_Reg_Date);
		visit.setVis_Room(vis_Room);
		visit.setPatientId(patientId);
		visit.setReceptionId(receptionId);
		visit.setScheduleId(scheduleId);
		
		visitRepository.save(visit);
		
		return "visit added";
	}

	@Override
	public void deleteOneVisit(int id) {
		visitRepository.deleteById(id);
		
	}

	@Override
	public List<Visit> listOfVisits() {
		return (List<Visit>) visitRepository.findAll();
	}

}
