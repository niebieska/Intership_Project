package com.softsystem.clinic.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softsystem.clinic.project.model.utils.PasswordEncoder;
import com.softsystem.clinic.project.dao.PatientDao;
import com.softsystem.clinic.project.dao.ReceptionRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.utils.DateParser;
import com.softsystem.clinic.project.services.CurrentReceptionistService;
import com.softsystem.clinic.project.services.RegistrationService;
import com.softsystem.clinic.project.validator.RegistrationViewModel;

@Controller
public class RegisterForReceptionController {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	PatientDao patientDao;

	@Inject
	CurrentReceptionistService currentReceptionService;

	@Autowired
	ReceptionRepository receptionRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@GetMapping(value = "/registerForReception")
	public ModelAndView showRegistrationPage(Model model){
	
		if (currentReceptionService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			Reception reception = currentReceptionService.getReception();
			model.addAttribute("reception",reception);
			return new ModelAndView("/registerForReception", "model", new RegistrationViewModel());

		} else {
			// return to log in
			System.out.println("niezalogowany");
			return new ModelAndView("redirect:/login");
		}
	
	}

	/**
	 * @param model
	 * @param result
	 * @param redirectAttributes
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/registerForReception", method = RequestMethod.POST)
	public ModelAndView registerPost(@Valid @ModelAttribute("model") RegistrationViewModel model,
			final BindingResult result, final RedirectAttributes redirectAttributes) throws ParseException {

		String urlReception = "";
	

		if (currentReceptionService.isAuthenticated()) {

			urlReception = "redirect:/receptionist";
			System.out.println(currentReceptionService.getReception());
		} else {
			urlReception = "redirect:/login";
		}
		
		if (!result.hasErrors()) {
			if (patientDao.countPatientMRN(model.getPat_Mrn())) {
				result.reject("error.MrnExist", "MRN number already exists.");
			}
			else if (patientDao.countPatientEmail(model.getPat_Email()))
				result.reject("error.MrnExist", "E-mail field already exists.");
		}
		model.setPat_Passhash(PasswordEncoder.encodePass(model.getPat_Passhash()));
		if (result.hasErrors()) {
			return new ModelAndView("/registerForReception", "model", model);
		}

		model.setPat_Dob(DateParser.StringToDate(model.getPat_Dob()).toString());
		registrationService.registration(model);

		String infoMessages = "Registration was successful!";

		redirectAttributes.addFlashAttribute("infos", infoMessages);

		return new ModelAndView(urlReception);
	}
}
