package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView ("FormTitle");
		mv.addObject("title", new Title());
		
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView ("FormTitle");
		mv.addObject("title", titles.findOne(id));
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListTitle");
		List<Title> allTitles = titles.findAllOrderByName();

		mv.addObject("titles", allTitles);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Validated Title title, Errors errors ) {
		ModelAndView mv = new ModelAndView ("FormTitle");
		
		if (errors.hasErrors()) {
			mv.addObject("danger", "Title could not be saved.");
			return mv;
		}
		
		try {
			titles.save(title);
			mv = list();			
			mv.addObject("success", "Title saved with success!");
			return mv;
		}catch(Exception e) {
			mv.addObject("danger", "Title could not be saved.");
			return mv;
		}	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {		
		this.titles.delete(id);
	
		return "redirect:/titles";
	}
	
	
}
