package com.diegoliveiras.bookmarks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ApplicationController {
	@RequestMapping("")
	public String home() {
		return "Home";
	}
<<<<<<< HEAD
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Usuário e/ou senha inválidos");
		if (logout != null)
			model.addAttribute("message", "Deslogado com sucesso, Até mais....");
		return "login";
	}
=======

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("danger", "Your username and password is invalid.");
		if (logout != null)
			model.addAttribute("success", "You have been logged out successfully.");
		return "login";
	}

>>>>>>> Spring-Security
}
