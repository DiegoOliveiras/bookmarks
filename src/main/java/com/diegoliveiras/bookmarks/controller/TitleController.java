package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.diegoliveiras.bookmarks.model.Title;
import com.diegoliveiras.bookmarks.repository.Titles;

@Controller
@RequestMapping("/titles")
public class TitleController {
	
	@Autowired
	private Titles titles;
	
	@RequestMapping("/new")
	public String create() {
		return "NewTitle";
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListTitle");
		List<Title> allTitles = titles.findAll();
		
		mv.addObject("titles", allTitles);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Title title) {
		
		if (titles.save(title) != null) {
			ModelAndView mv = list();
			
			mv.addObject("success", "Title created with success!");

			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView ("NewTitle");
			mv.addObject("danger", "Bookmark could not be created.");
			return mv;
		}		
	}
	
}
