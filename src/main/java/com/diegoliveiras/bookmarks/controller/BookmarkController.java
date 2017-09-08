package com.diegoliveiras.bookmarks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegoliveiras.bookmarks.model.Bookmark;

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
		bookmarks.save(bookmark);
		
		ModelAndView mv = new ModelAndView ("NewBookmark");
		mv.addObject("message", "Bookmark saved with success!");
		
		return mv;
	}
}
