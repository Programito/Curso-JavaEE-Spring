package com.mvcdao.org.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdao.org.models.UserBean;
import com.mvcdao.org.service.IProductoService;
import com.mvcdao.org.service.IUserService;


@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView showUser(Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("newUser");
		mav.addObject("newUser", new UserBean());
		return mav;
	}

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newUser") UserBean newUser) {

		System.out.println(userService.findByUsername("sdfsdf1123"));
		ModelAndView mav = null;
		if(userService.existUser(newUser.getUsername())) {
			mav = new ModelAndView("newUser");
			mav.addObject("error", "El " + newUser.getUsername() + " ya existe");
			return mav;
		}
		else {
			userService.saveUser(newUser);
			mav = new ModelAndView("userRegistered");
			mav.addObject("msg", newUser.getUsername());
		}
		return mav;
	}

}
