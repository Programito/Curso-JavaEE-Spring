package com.mvcemployee.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcemployee.app.models.entity.Employee;
import com.mvcemployee.app.models.entity.Phone;
import com.mvcemployee.app.models.service.IEmployeeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		Employee employee = new Employee();
		employee.setName("Juan");
		Phone phone = new Phone();
		phone.setPhoneNumber("12312312321");
		phone.setEmployee(employee);
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(phone);
		employee.setPhones(phones);
		employeeService.saveEmployee(employee);
		employee = employeeService.findOne(1L);
		if (employee == null) {
			System.out.println("es nulo");
		} else {
			System.out.println("NO es nulo");
			System.out.println(employee.getName());
			if (employee.getPhones() == null) {
				System.out.println("phone es null");
			} else {
				System.out.println("phone NO es null");
				System.out.println(employee.getPhones().size());
				System.out.println(employee.getPhones().get(0).getPhoneNumber());
			}

		}
		// employeeService.savePhone(phone);

		return "home";
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView viewProducts(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("viewemployees");
		List<Employee> employees = employeeService.findAllEmployee();
		mav.addObject("employees",employees);
		return mav;
	}

	@RequestMapping(value = "addemployee", method = RequestMethod.GET)
	public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("addemployee");
		mav.addObject("newEmployee", new Employee());
		return mav;
	}

	@RequestMapping(value = "addemployee", method = RequestMethod.POST)
	public String registerEmployee(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newEmployee") Employee newEmployee, RedirectAttributes flash, Model model) {
		
		if(newEmployee!=null && newEmployee.getName()!= null && newEmployee.getName()!="") {
			employeeService.saveEmployee(newEmployee);
		}
		
		return "redirect:/";
	}
	
}
