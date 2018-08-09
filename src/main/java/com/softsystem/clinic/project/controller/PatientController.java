package com.softsystem.clinic.project.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.dao.PatientRepository;
import com.softsystem.clinic.project.model.Patient;
import com.softsystem.clinic.project.services.CurrentPatientService;
import com.softsystem.clinic.project.services.PatientServiceImpl;
import com.softsystem.clinic.project.validator.LoginViewModel;
import com.softsystem.clinic.project.validator.RegistrationViewModel;

@RestController
public class PatientController {

	@Autowired
	private PatientServiceImpl patientServiceImpl;

	@Autowired
	private PatientRepository patientRepository;
	
	

	@Inject
	CurrentPatientService currentPaientService;

	

	@GetMapping(value="/patient")
	public ModelAndView showPatientPage(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (currentPaientService.isAuthenticated()) {
			// if logged in it passes to the patient page
			System.out.println("zalogowany");
			modelAndView.setViewName("/patient");

		} else {
			// return to log in
			System.out.println("niezalogowany");
		 modelAndView.setViewName("redirect:/login");
		}
		
		Patient patient = currentPaientService.getPatient();
		
		 model.addAttribute("patient",patient);
		
		return modelAndView;
	}
	
	@GetMapping(value = "/allpatients")
	public List<Patient> getAllPatients() {
		return patientServiceImpl.listOfPatients();
	}

	@DeleteMapping(value="/deletepatient/{id}")
	private void delete(@PathVariable int id) {
		patientServiceImpl.deleteOnePatient(id);

	}
	
	@PutMapping("/updatepatient/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Patient patient, @PathVariable int id) {

		Optional<Patient> patientOptional = patientServiceImpl.findOnePatient(id);

		if (!patientOptional.isPresent())
			return ResponseEntity.notFound().build();

		patient.setId(id);
		
		patientRepository.save(patient);

		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value="/savepatient")
	public String savePatient(@RequestParam String pat_Mrn,@RequestParam String pat_Fname,@RequestParam String pat_Lname,@RequestParam String pat_Mname,@RequestParam Date pat_Dob,@RequestParam String pat_Sex,@RequestParam String pat_Email,@RequestParam String pat_Passhash,@RequestParam int pat_Phone,@RequestParam boolean pat_Confirmation){
	

	patientServiceImpl.add(pat_Mrn, pat_Fname, pat_Lname, pat_Mname, pat_Dob, pat_Sex, pat_Email, pat_Passhash, pat_Phone, pat_Confirmation);

	return "patient added";
	}
	
	
	
	
}
