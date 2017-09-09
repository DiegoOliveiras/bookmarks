package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diegoliveiras.bookmarks.model.Bookmark;
import com.diegoliveiras.bookmarks.model.User;
import com.diegoliveiras.bookmarks.repository.Bookmarks;
import com.diegoliveiras.bookmarks.repository.Users;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Users users;
	@Autowired
	private Bookmarks bookmarks;
	
	@RequestMapping("/new")
	public String create() {
		return "NewUser";
	}
	
	@RequestMapping
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView ("ListUser");
		List<User> allUsers = users.findAll();
		
		mv.addObject("users", allUsers);
		return mv;
	}
	
	@RequestMapping("/signin")
	public String signIn() {
		return "SignIn";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(User user) {
		
		if (users.save(user) != null) {
			ModelAndView mv = new ModelAndView ("SignIn");
			
			mv.addObject("success", "User created with success!");

			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView ("NewUser");
			mv.addObject("danger", "User could not be created.");
			return mv;
		}		
	}
}
