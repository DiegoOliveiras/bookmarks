package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.model.Title;
import com.diegoliveiras.bookmarks.repository.Bookmarks;
import com.diegoliveiras.bookmarks.repository.Titles;



@Controller
@RequestMapping("/bookmarks")
public class BookmarkController {
	
	@Autowired
	private Bookmarks bookmarks;
	
	@Autowired
	private Titles titles;
	
	@RequestMapping("/new")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView ("NewBookmark");
		List<Title> allTitles = titles.findAll();
		mv.addObject("titles", allTitles);
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListBookmark");
		
		List<Bookmark> allBookmarks = bookmarks.findAll();
		List<Title> allTitles = titles.findAll();
		
		mv.addObject("bookmarks", allBookmarks);
		mv.addObject("titles", allTitles);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(Bookmark bookmark) {
		
		try {
			bookmarks.save(bookmark);
			ModelAndView mv = list();
			mv.addObject("success", "Bookmark created with success!");

			return mv;
		}catch (Exception e) {
			ModelAndView mv = new ModelAndView ("NewBookmark");
			mv.addObject("danger", "Bookmark could not be created.");
			return mv;
		}		
	}
}
