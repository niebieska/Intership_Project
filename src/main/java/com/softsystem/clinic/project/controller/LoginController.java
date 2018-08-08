package com.softsystem.clinic.project.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softsystem.clinic.project.validator.LoginViewModel;

@Controller
public class LoginController {

	
	@GetMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("infos") final ArrayList<String> infos,
                              final BindingResult bindingResult){

      

        ModelAndView modelAndView = new ModelAndView();
        if ((infos != null) && (!bindingResult.hasErrors())) {
            modelAndView.addObject("infos", infos);
        }

     
        return new ModelAndView("/login","model",new LoginViewModel());
    }
	
	@PostMapping(value="/login")
	public ModelAndView loginPost(@Valid @ModelAttribute ("model")LoginViewModel model,final BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (result.hasErrors()) {
            return new ModelAndView("/login","model",model);
        }
	
		
		
		
		return modelAndView;
	}
	
}
