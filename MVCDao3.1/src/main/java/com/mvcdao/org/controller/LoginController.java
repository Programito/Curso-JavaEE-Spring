package com.mvcdao.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdao.org.models.LoginBean;
import com.mvcdao.org.service.IUserService;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		 logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("msg", "Please Enter Your Login Details o Register your data");

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginBean());
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginBean login) {

		System.out.println(login.getUserName());
		System.out.println(login.getPassword());

		ModelAndView mav = null;

		if (userService.login(login.getUserName(), login.getPassword())) {
			mav = new ModelAndView("success");
			mav.addObject("msg", login.getUserName());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}

//		if (null != login && login.getUserName().equals("admin")) {
//			mav = new ModelAndView("success");
//			mav.addObject("msg", login.getUserName());
//		} else {
//			mav = new ModelAndView("login");
//			mav.addObject("message", "Username or Password is wrong!!");
//		}
		return mav;
	}

}
