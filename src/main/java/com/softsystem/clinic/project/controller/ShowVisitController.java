package com.softsystem.clinic.project.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.dao.VisitRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Visit;
import com.softsystem.clinic.project.services.CurrentReceptionistService;
import com.softsystem.clinic.project.validator.ConfirmViewModel;


@RestController
public class ShowVisitController {

	@Inject
	CurrentReceptionistService currentReceptionService;
	@Autowired
	private VisitRepository visitRepository;
	
	@Autowired
	PatientRepository pr;
	

	@GetMapping(value = "/showVisits")
	public ModelAndView showAllPatients(Model model, @ModelAttribute("model2") ConfirmViewModel model2) {
		ModelAndView modelAndView = new ModelAndView();

		if (currentReceptionService.isAuthenticated()) {
			// if logged in it passes to the patient page
		    List<Visit> findAllIncomingVisitsForAllPatients = (List<Visit>) visitRepository.findAllIncomingVisitsForAllPatients(); 
		    model.addAttribute("findAllIncomingVisitsForAllPatients", findAllIncomingVisitsForAllPatients); 
			System.out.println("zalogowany");
			modelAndView.setViewName("/showVisits");

		} else {
			// return to log in
			System.out.println("niezalogowany");
			modelAndView.setViewName("redirect:/login");
		}

		//List<Visit> visitList = (List<Visit>) visitRepository.findAllVis();
		
		//for(Visit visit: visitList) {
			//System.out.println(visit.getVis_Room());
		//}

		Reception reception = currentReceptionService.getReception();
		
		
		

		//model.addAttribute("visitList", visitList);
		model.addAttribute("reception", reception);

		return modelAndView;
	}
	
	@PostMapping(value = "/showVisits")
	public ModelAndView showAllPatients(@ModelAttribute("model2") ConfirmViewModel model2) {
	
		
		List<Visit> wizyty= visitRepository.findAllIncomingVisitsForAllPatients();
		
		for(Visit visit : wizyty) {
			System.out.println(visit);
			visit.setVis_Confirmation(model2.isPat_Confirmation());
			visitRepository.save(visit);
			
		}
	
		return new ModelAndView("redirect:/showVisits");
	}
}
















