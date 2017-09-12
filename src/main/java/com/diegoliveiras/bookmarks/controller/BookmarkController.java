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
		ModelAndView mv = new ModelAndView ("FormBookmark");
		List<Title> allTitles = titles.findAllOrderByName();

		mv.addObject("bookmark", new Bookmark());
		mv.addObject("titles", allTitles);

		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id) {
		this.bookmarks.delete(id);		

		return "redirect:/bookmarks";
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView ("FormBookmark");
		mv.addObject("bookmark", bookmarks.findOne(id));

		List<Title> allTitles = titles.findAllOrderByName();
		mv.addObject("titles", allTitles);	

		return mv;
	}

	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListBookmark");

		List<Bookmark> allBookmarks = bookmarks.findAllOrderByTitle();

		mv.addObject("bookmarks", allBookmarks);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Validated Bookmark bookmark, Errors errors) {
		ModelAndView mv = new ModelAndView ("FormBookmark");

		if (errors.hasErrors()) {
			List<Title> allTitles = titles.findAllOrderByName();

			mv.addObject("titles", allTitles);

			mv.addObject("danger", "Bookmark could not be saved.");
			return mv;
		}

		try {
			bookmarks.save(bookmark);
			mv = list();
			mv.addObject("success", "Bookmark saved with success!");

			return mv;
		}catch (Exception e) {
			mv.addObject("danger", "Bookmark could not be saved.");
			return mv;
		}		
	}
}
