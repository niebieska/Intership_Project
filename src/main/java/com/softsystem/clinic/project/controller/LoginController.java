package com.softsystem.clinic.project.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.utils.PasswordEncoder;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;
import com.softsystem.clinic.project.validator.LoginViewModel;

@Controller
public class LoginController {

	@Autowired
	PatientRepository patientRepository;

	@Inject
	CurrentPatientService currentPaientService;

	@Autowired
	ReceptionRepository receptionReposiory;

	@Inject
	CurrentReceptionistService currentReceptionService;

	@GetMapping(value = "/login")
	public ModelAndView login(@ModelAttribute("infos") final ArrayList<String> infos,
			final BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();

		if (currentPaientService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			modelAndView.setViewName("/patient");
		}

		else if (currentReceptionService.isAuthenticated()) {
			modelAndView.setViewName("/receptionist");

		} else {
			// return to log in
			System.out.println("niezalogowany");
			modelAndView.setViewName("redirect:/login");
		}

		if ((infos != null) && (!bindingResult.hasErrors())) {
			modelAndView.addObject("infos", infos);
		}

		return new ModelAndView("/login", "model", new LoginViewModel());
	}

	@SuppressWarnings("unused")
	@PostMapping(value = "/login")
	public ModelAndView loginPost(@Valid @ModelAttribute("model") LoginViewModel model, final BindingResult result) {

		Patient patient = patientRepository.findByPatEmail(model.getPat_Email());

		Reception reception = receptionReposiory.findByRecEmail(model.getPat_Email());

		if (reception != null) {
			if (!result.hasErrors()) {
				if (reception == null) {
					result.reject("error.loginError", "Invalid login or password.");
				} else if (!model.getPat_Passhash().equals(reception.getRecPasshash())) {
					result.reject("error.loginError", "Invalid login or password.");
				}
			}

			if (result.hasErrors()) {
				return new ModelAndView("/login", "model", model);
			}

			currentReceptionService.setReception(reception);
			return new ModelAndView("redirect:/receptionist");
		} else {

			System.out.println("pacjent");
			if (!result.hasErrors()) {
				if (patient == null) {
					result.reject("error.loginError", "Invalid login or password.");
				} else if (!PasswordEncoder.checkPassword(model.getPat_Passhash(), patient.getPat_Passhash())) {
					result.reject("error.loginError", "Invalid login or password.");
				}
			}

			if (result.hasErrors()) {
				return new ModelAndView("/login", "model", model);
			}

			currentPaientService.setPatient(patient);

			return new ModelAndView("redirect:/patient");
		}

	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		currentPaientService.logOut();
		session.invalidate();

		return "redirect:/login";
	}
}
