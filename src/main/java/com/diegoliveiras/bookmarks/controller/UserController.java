package com.diegoliveiras.bookmarks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(User user, Errors erros) {
		
		if (erros.hasErrors()) {
			ModelAndView mv = new ModelAndView ("NewUser");
			mv.addObject("danger", "User could not be created.");
			mv.addObject("message", "User created with success!");
			
			System.out.println("passei aqui 1"+erros.getAllErrors().toString());
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView ("NewUser");
			
			mv.addObject("success", "User created with success!");
			mv.addObject("message", "User created with success!");
			
			System.out.println("passei aqui 2"+erros.getAllErrors().toString());
			return mv;
		}		
	}
}
