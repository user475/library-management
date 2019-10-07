package com.virtusa.jpmc.management.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.jpmc.management.models.User;
import com.virtusa.jpmc.management.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute User user) {
		
		String uName = user.getUsername();
		User existingUser = userService.getUserByUsername(uName);
		if(existingUser == null) {
			userService.register(user);
			return new ModelAndView("redirect:/loginPage");
		}
		return new ModelAndView("redirect:/registerPage");
	}

	@RequestMapping(value = "/registerPage", method = RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("register");
		return model;
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@ModelAttribute User user, Model model,HttpServletResponse response) {

		String username = user.getUsername();
		String Password = user.getPassword();
		User dbUser = userService.getUserByUsername(username);
		if (dbUser == null) {
			model.addAttribute("error", "invalid user name please register");
			return "/register.html";
		}
		if(dbUser.getPassword().equals(Password)) {
			response.addCookie(new Cookie("userType",dbUser.getType()));
			response.addCookie(new Cookie("userName",dbUser.getName()));
			 return "redirect:/list_books";
		  } 
		return "/login.html";
		 
	}
	@GetMapping("/logout")
	public String logout() {
		/*
		 * ModelAndView model = new ModelAndView(); model.setViewName("loginPage");
		 */
		return "redirect:/loginPage";
	}
}
