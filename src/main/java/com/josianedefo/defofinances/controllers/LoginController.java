package com.josianedefo.defofinances.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLogin(Model model) {
		//model.addAttribute("transactions", this.transactionRepository.findAll());
		return "login";
	}
	
	
}
