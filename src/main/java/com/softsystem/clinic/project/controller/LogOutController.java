package com.softsystem.clinic.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.softsystem.clinic.project.dao.ReceptionRepository;
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
