package com.softsystem.clinic.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@Controller
public class ShowPatientsController {

	@Autowired
	private PatientRepository patientRepository;
	
	
	@Inject
	CurrentReceptionistService currentReceptionService;
	
	@Inject
	CurrentReceptionistService currentRecetpionService;
	
	@GetMapping(value="/showPatients")
	public ModelAndView showAllPatients(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (currentReceptionService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			modelAndView.setViewName("/showPatients");

		} else {
			// return to log in
			System.out.println("niezalogowany");
		 modelAndView.setViewName("redirect:/login");
		}
		
		
		List<Patient> patientList =  (List<Patient>) patientRepository.findAll();
		
		Reception reception = currentReceptionService.getReception();
		
		
		model.addAttribute("patientList",patientList);
		model.addAttribute("reception",reception);
		
		return modelAndView;
	}
}
