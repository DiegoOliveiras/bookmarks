package com.diegoliveiras.bookmarks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class ApplicationController {
	@RequestMapping("/home")
	public String home() {
		return "Home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Usuário e/ou senha inválidos");
		if (logout != null)
			model.addAttribute("message", "Deslogado com sucesso, Até mais....");
		return "login";
	}
}
