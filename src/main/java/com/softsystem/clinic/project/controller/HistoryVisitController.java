package com.softsystem.clinic.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.VisitRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Visit;
import com.softsystem.clinic.project.services.CurrentPatientService;


@Controller
public class HistoryVisitController {

	@Inject
	CurrentPatientService currentPatientService;
	
	@Autowired
	private VisitRepository visitRepository;

	
	@GetMapping(value="/historyVisit")
	public ModelAndView showHistoryVisitPage(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (currentPatientService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			System.out.println("Patient id "+currentPatientService.getPatient().getId());
			Patient patient = currentPatientService.getPatient();
			
			List<Visit> findAllPerformedVisitsForSinglePatient = visitRepository.findAllPerformedVisitsForSinglePatient(patient);
			model.addAttribute("findAllPerformedVisitsForSinglePatient", findAllPerformedVisitsForSinglePatient);
			for(Visit visit : findAllPerformedVisitsForSinglePatient) {
				System.out.println(visit);
			}
			
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
