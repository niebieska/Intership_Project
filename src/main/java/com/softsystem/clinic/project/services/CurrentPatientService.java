package com.softsystem.clinic.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.model.Patient;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentPatientService {
	
	private Patient patient;
	
	@Autowired
	PatientRepository patientRepository;
	
	public Patient getPatient() {
		if(patient!= null) {
			
			patient = patientRepository.findById(patient.getId());
		}
		return patient;
	}
	
	public void setPatient(Patient patient){
        this.patient=patient;
    }
    public boolean isAuthenticated() {
        return (patient != null);
    }

    public void logOut(){
        patient = null;
    }

}
