package com.diegoliveiras.bookmarks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ApplicationController {
	@RequestMapping("/home")
	public String home() {
		return "Home";
	}

}
