/**
 *HomeController.java
 *
 *created at Oct 27, 2015 
 * 
 *@author Vasil Sokolov <vasilsokolov@abv.bg>
 *
 * Copyright (c) 2015 . All Rights Reserved.
 */
package com.softserve.academy.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

	@RequestMapping(value = {"/"})
	public String homePage(ModelMap model) {
		String library = "Welcome to The Library!!!";
		model.addAttribute("library", library);		
		return "home";
	}
}
