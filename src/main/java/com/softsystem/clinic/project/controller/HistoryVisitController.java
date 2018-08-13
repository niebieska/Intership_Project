package com.softsystem.clinic.project.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@Controller
public class HistoryVisitController {

	@Inject
	CurrentPatientService currentPatientService;

	
	@GetMapping(value="/historyVisit")
	public ModelAndView showHistoryVisitPage(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (currentPatientService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			modelAndView.setViewName("/historyVisit");

		} else {
			// return to log in
			System.out.println("niezalogowany");
		 modelAndView.setViewName("redirect:/login");
		}
		
		Patient patient = currentPatientService.getPatient();
		
		model.addAttribute("patient",patient);
		
		return modelAndView;
	}
	
}
