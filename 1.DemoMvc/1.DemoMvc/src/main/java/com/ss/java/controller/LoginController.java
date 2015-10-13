package com.ss.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ss.java.model.Login;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm(Model model) {
		Login login = new Login();
		model.addAttribute("loginForm", login);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String registrationSuccessful(@ModelAttribute("loginForm") Login login) {
		boolean status = login.validate();
		if (status) {
			return "login-success";
		} else {
			return "login-error";
		}
	}

}
