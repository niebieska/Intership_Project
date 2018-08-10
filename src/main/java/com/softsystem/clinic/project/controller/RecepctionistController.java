package com.softsystem.clinic.project.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@Controller
public class RecepctionistController {
		
	
	@Inject
	CurrentReceptionistService currentRecetionService;
	
	
	@GetMapping(value ="/receptionist")
	public ModelAndView showReceptionPage(Model model) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(currentRecetionService.isAuthenticated()) {
			modelAndView.setViewName("/receptionist");
		}
		else {
			// return to log in
			System.out.println("niezalogowany");
			modelAndView.setViewName("redirect:/login");
		}
		 
	
		 return modelAndView;
	}
	
	
	@PostMapping(value="/receptionist")
	public ModelAndView receptionPost() {
		
		return null;
	}

}
