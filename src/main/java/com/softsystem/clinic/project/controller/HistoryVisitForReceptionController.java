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
import com.softsystem.clinic.project.model.Reception;
import com.softsystem.clinic.project.model.Visit;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.CurrentReceptionistService;

@Controller
public class HistoryVisitForReceptionController {

	@Inject
	CurrentPatientService currentPatientService;

	@Inject
	CurrentReceptionistService currentReceptionService;

	@Autowired
	private VisitRepository visitRepository;

	@GetMapping(value = "/allHistoryVisit")
	public ModelAndView showAllHistoryVisitPage(Model model) {
		ModelAndView modelAndView = new ModelAndView();

		if (currentReceptionService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");

			modelAndView.setViewName("/allHistoryVisit");

		} else {
			// return to log in
			System.out.println("niezalogowany");
			modelAndView.setViewName("redirect:/login");
		}

		Patient patient = currentPatientService.getPatient();

		List<Visit> findAllPerformedVisitsForAllPatients = visitRepository.findAllPerformedVisitsForAllPatients();

		model.addAttribute("findAllPerformedVisitsForAllPatients", findAllPerformedVisitsForAllPatients);
		for (Visit visit : findAllPerformedVisitsForAllPatients) {
			System.out.println(visit);
		}
		Reception reception = currentReceptionService.getReception();

		model.addAttribute("reception", reception);
		model.addAttribute("patient", patient);

		return modelAndView;
	}

}
