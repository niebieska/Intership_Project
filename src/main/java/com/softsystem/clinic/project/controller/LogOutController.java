package com.softsystem.clinic.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;


@Controller
public class LogOutController {
	
	@Inject
	CurrentPatientService currentPatientService;

	@Inject
	CurrentReceptionistService currentReceptionService;
	
	@GetMapping(value = "/logout")
    public String logout(HttpSession session) {
		if(currentPatientService.isAuthenticated()) {
			currentPatientService.logOut();
		}else if(currentReceptionService.isAuthenticated()) {
			currentReceptionService.logOut();
		}
		
		
        session.invalidate();

        return "redirect:/login";
    }
	   
}
