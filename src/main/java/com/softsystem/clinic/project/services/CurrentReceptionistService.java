package com.softsystem.clinic.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;


@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentReceptionistService {

	
	
	
	private Reception reception;
	
	@Autowired
	ReceptionRepository receptionRepository;
	
	public Reception getReception() {
		if(reception!= null) {
			
			reception = receptionRepository.findById(reception.getId());
		}
		return reception;
	}
	
	public void setReception(Reception reception){
        this.reception=reception;
    }
    public boolean isAuthenticated() {
        return (reception != null);
    }

    public void logOut(){
    	reception = null;
    }

}

