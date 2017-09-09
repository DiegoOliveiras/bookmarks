package com.diegoliveiras.bookmarks.controller;

import java.util.List;

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
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListBookmark");
		List<Bookmark> allBookmarks = bookmarks.findAll();
		
		mv.addObject("bookmarks", allBookmarks);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Bookmark bookmark) {
		
		if (bookmarks.save(bookmark) != null) {
			ModelAndView mv = list();
			
			mv.addObject("success", "Bookmark created with success!");

			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView ("NewBookmark");
			mv.addObject("danger", "Bookmark could not be created.");
			return mv;
		}		
	}
}
