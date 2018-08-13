package com.softsystem.clinic.project.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Note;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Schedule;
import com.softsystem.clinic.project.model.Visit;


@Service
public class ReceptionServiceImpl implements ReceptionService{

	@Autowired
	private ReceptionRepository receptionRepository;
	
	
	@Override
	public String add(String rec_FName, String rec_LName, int rec_PhoneEnum) {
		Reception reception=new Reception();
		reception.setRec_FName(rec_FName);
		reception.setRec_LName(rec_LName);
		reception.setRec_PhoneEnum(rec_PhoneEnum);
		
		receptionRepository.save(reception);
		return "reception added";
	}


	@Override
	public void deleteOneReception(int id) {
		receptionRepository.deleteById(id);
		
	}

	@Override
	public List<Reception> listOfReceptions() {
		return (List<Reception>) receptionRepository.findAll();
	}
	
	@Override
	public Reception findById(int id) {
		Reception rec=new Reception();
		try {
			rec = receptionRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rec;
	}


	@Override
	public Reception findByRecEmail(String recEmail) {
		Reception rec=receptionRepository.findByRecEmail(recEmail);
		return rec;
	}

}
