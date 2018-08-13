package com.softsystem.clinic.project.controller;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@RestController
public class RecepctionistController {
		
	
	@Inject
	CurrentReceptionistService currentReceptionService;
	
	
	@GetMapping(value ="/receptionist")
	public ModelAndView showReceptionPage(Model model) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(currentReceptionService.isAuthenticated()) {
			modelAndView.setViewName("/receptionist");
		}
		else {
			// return to log in
			System.out.println("niezalogowany");
			modelAndView.setViewName("redirect:/login");
		}
		
		Reception reception = currentReceptionService.getReception();
		model.addAttribute("reception",reception);
	
		 return modelAndView;
	}
	
	
	@PostMapping(value="/receptionist")
	public ModelAndView receptionPost() {
		
		return null;
	}

}
