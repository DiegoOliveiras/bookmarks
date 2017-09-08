package com.diegoliveiras.bookmarks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.repository.Bookmarks;

@Controller
@RequestMapping("/bookmarks")
public class BookmarkController {
	
	@Autowired
	private Bookmarks bookmarks;
	
	@RequestMapping("/new")
	public String create() {
		return "NewBookmark";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Bookmark bookmark) {
		ModelAndView mv = new ModelAndView ("NewBookmark");
		if (bookmarks.save(bookmark) != null) {
			mv.addObject("success", "Bookmark saved with success!");
		}
		else {
			mv.addObject("danger", "Bookmark could not be created");
		}
	
		
		
		return mv;
	}
}
