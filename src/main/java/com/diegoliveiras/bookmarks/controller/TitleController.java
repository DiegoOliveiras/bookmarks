package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.model.Count;
import com.diegoliveiras.bookmarks.model.Title;
import com.diegoliveiras.bookmarks.repository.Bookmarks;
import com.diegoliveiras.bookmarks.repository.Titles;

@Controller
@RequestMapping("/titles")
public class TitleController {
	
	@Autowired
	private Titles titles;
	
	@Autowired
	private Bookmarks bookmarks;
	
	@RequestMapping("/new")
	public String create() {
		return "NewTitle";
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListTitle");
		List<Title> allTitles = titles.findAll();
		List<String> allBookmarks = bookmarks.countByTitle();
		
		mv.addObject("titles", allTitles);
		mv.addObject("bookmarks", allBookmarks);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Title title) {
		
		
		try {
			titles.save(title);
			ModelAndView mv = list();			
			mv.addObject("success", "Title created with success!");
			return mv;
		}catch(Exception e) {
			
			ModelAndView mv = new ModelAndView ("NewTitle");
			mv.addObject("danger", "Bookmark could not be created.");
			return mv;
		}	
	}
	
}
