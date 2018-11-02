package com.mvcdao.org.controller;

import java.util.Map;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdao.org.models.UserBean;

import com.mvcdao.org.service.IUserService;
import org.springframework.context.MessageSource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private MessageSource messageSource;

	private String emailPattern = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";

	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView showUser(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response,
			Locale locale) {
		ModelAndView mav = new ModelAndView("newUser");
		mav.addObject("newUser", new UserBean());
		mav.addObject("title", messageSource.getMessage("text.register.title", null, locale));
		return mav;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newUser") UserBean newUser, Locale locale) {

		ModelAndView mav = null;

		boolean error = false;

		if (newUser.getUsername().isEmpty()) {
			error = true;
			mav = new ModelAndView("newUser");
			mav.addObject("username", messageSource.getMessage("text.register.error.username", null, locale));
		}

		if (newUser.getPassword().isEmpty()) {
			error = true;
			if (mav == null) {
				mav = new ModelAndView("newUser");
			}
			mav.addObject("password", messageSource.getMessage("text.register.error.password", null, locale));
		}

		if (newUser.getFirstname().isEmpty()) {
			error = true;
			if (mav == null) {
				mav = new ModelAndView("newUser");
			}
			mav.addObject("firstname", messageSource.getMessage("text.register.error.firstname", null, locale));
		}

		if (newUser.getLastname().isEmpty()) {
			error = true;
			if (mav == null) {
				mav = new ModelAndView("newUser");
			}
			mav.addObject("lastname", messageSource.getMessage("text.register.error.lastname", null, locale));
		}

		if (newUser.getEmail().isEmpty()) {
			error = true;
			if (mav == null) {
				mav = new ModelAndView("newUser");
			}
			mav.addObject("email", messageSource.getMessage("text.register.error.email", null, locale));
		} else {
			Pattern pattern = Pattern.compile(emailPattern);
			Matcher matcher = pattern.matcher(newUser.getEmail());
			if (!matcher.matches()) {
				error = true;
				if (mav == null) {
					mav = new ModelAndView("newUser");
				}
				mav.addObject("email", messageSource.getMessage("text.register.error.pattern.email", null, locale));
			}
		}

		if (newUser.getAddress().isEmpty()) {
			error = true;
			if (mav == null) {
				mav = new ModelAndView("newUser");
			}
			mav.addObject("address", messageSource.getMessage("text.register.error.address", null, locale));
		}

		if (error) {
			return mav;
		}

		if (userService.existUser(newUser.getUsername())) {
			mav = new ModelAndView("newUser");
			mav.addObject("error", messageSource.getMessage("text.register.error.repeated", new Object[] {newUser.getUsername()}, locale));
			return mav;
		} else {
			userService.saveUser(newUser);
			mav = new ModelAndView("userRegistered");
			mav.addObject("msg", newUser.getUsername());
		}
		return mav;
	}

}
