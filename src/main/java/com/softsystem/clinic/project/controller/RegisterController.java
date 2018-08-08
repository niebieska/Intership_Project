package com.softsystem.clinic.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softsystem.clinic.project.model.utils.PasswordEncoder;
import com.softsystem.clinic.project.model.utils.DateParser;
import com.softsystem.clinic.project.services.RegistrationService;
import com.softsystem.clinic.project.validator.RegistrationViewModel;

@org.springframework.stereotype.Controller 
public class RegisterController {	
	
	@Autowired
	RegistrationService registrationService;
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(       Date.class,     
	                         new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));   
	}
	@RequestMapping(value="/register",method =RequestMethod.GET)
	public ModelAndView showRegistrationPage() {
		
		return new ModelAndView("/register", "model", new RegistrationViewModel());
	}
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
    public ModelAndView registerPost(@Valid @ModelAttribute ("model")RegistrationViewModel model, final BindingResult result,
                                     final RedirectAttributes redirectAttributes) throws ParseException{
	
		model.setPat_Passhash(PasswordEncoder.encodePass(model.getPat_Passhash()));
        if (result.hasErrors()) {
            return new ModelAndView("/register","model",model);
        }
  
        model.setPat_Dob(DateParser.StringToDate(model.getPat_Dob()).toString());
        registrationService.registration(model);
        
        List<String> infoMessages = new ArrayList<>();
        infoMessages.add("Registration was successful! Now you can log in.");

        redirectAttributes.addFlashAttribute("infos", infoMessages);
		
		 return new ModelAndView("redirect:/login");
	}
}
