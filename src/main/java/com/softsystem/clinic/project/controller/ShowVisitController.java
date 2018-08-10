package com.softsystem.clinic.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.VisitRepository;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Visit;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@Controller
public class ShowVisitController {

	@Inject
	CurrentReceptionistService currentReceptionService;
	@Autowired
	private VisitRepository visitRepository;
	

	@GetMapping(value = "/showVisits")
	public ModelAndView showAllPatients(Model model) {
		ModelAndView modelAndView = new ModelAndView();

		if (currentReceptionService.isAuthenticated()) {
			// if logged in it passes to the patient page
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
}
