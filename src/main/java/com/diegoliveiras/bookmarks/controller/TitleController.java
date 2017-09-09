package com.diegoliveiras.bookmarks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.diegoliveiras.bookmarks.repository.Titles;

@Controller
@RequestMapping("/titles")
public class TitleController {
	
	@Autowired
	private Titles titles;
	
	@RequestMapping("/new")
	public String create() {
		return "NewUser";
	}
}
