package com.softsystem.clinic.project.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softsystem.clinic.project.validator.RegistrationViewModel;

@org.springframework.stereotype.Controller 
public class RegisterController {

	@RequestMapping(value="/register",method =RequestMethod.GET)
	public ModelAndView showRegistrationPage() {
		
		return new ModelAndView("/register", "model", new RegistrationViewModel());
	}
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute ("model")RegistrationViewModel model, final BindingResult result,
                                     final RedirectAttributes redirectAttributes){
		
        if (result.hasErrors()) {
            return new ModelAndView("/register","model",model);
        }
        
        List<String> infoMessages = new ArrayList<>();
        infoMessages.add("Rejestracja powiodła się! Teraz możesz sie zalogować.");

        redirectAttributes.addFlashAttribute("infos", infoMessages);
		
		 return new ModelAndView("redirect:/welcome");
	}
	
}
