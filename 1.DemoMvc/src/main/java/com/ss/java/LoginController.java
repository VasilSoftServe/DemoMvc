package com.ss.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm(Model model) {

		Login login = new Login();
		String userName = login.getName();
		String password = login.getPassword();
		String email = login.getEmail();

		model.addAttribute("username", userName);
		model.addAttribute("password", password);
		model.addAttribute("email", email);
		model.addAttribute("loginForm", login);

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String registrationSuccessful(@ModelAttribute("loginForm") Login login) {

//		boolean status = login.validate();
//
//		if (status) {
//			return "login-sussecc";
//		} else {
//			return "login-error";
//		}
		
		return  "login-sussecc";
	}

}
