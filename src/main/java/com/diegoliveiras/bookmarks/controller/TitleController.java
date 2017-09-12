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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView save(@Validated Title title, Errors errors, RedirectAttributes attr ) {
		ModelAndView mv = new ModelAndView ("FormTitle");
		
		if (errors.hasErrors()) {
			mv.addObject("danger", "Title could not be saved.");
			return mv;
		}
		
		try {
			titles.save(title);
			attr.addFlashAttribute("success", "Title saved qith success!");
			return new ModelAndView("redirect:titles");
		}catch(Exception e) {
			mv.addObject("danger", "Title could not be saved.");
			return mv;
		}	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id, RedirectAttributes attr) {		
		this.titles.delete(id);
	
		attr.addFlashAttribute("danger", "Title was removed with success.");
		return "redirect:/titles";
	}
	
	
}
