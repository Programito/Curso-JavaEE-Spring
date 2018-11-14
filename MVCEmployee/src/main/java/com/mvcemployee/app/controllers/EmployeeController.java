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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Map;

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
	public ModelAndView viewEmployees(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("viewemployees");
		List<Employee> employees = employeeService.findAllEmployee();
		mav.addObject("employees", employees);
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

		if (newEmployee != null && newEmployee.getName() != null && newEmployee.getName() != "") {
			employeeService.saveEmployee(newEmployee);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "viewemployee/{id}", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@PathVariable("id") Long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav;

		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			System.out.println("Employee con id " + id + "no existe");
			mav = new ModelAndView("viewemployees");
		} else {
			mav = new ModelAndView("viewemployee");
			mav.addObject("employee", employee);
			mav.addObject("phones",employee.getPhones());
			System.out.println(employee.getPhones().size());
		}
		return mav;
	}

//	@RequestMapping(value = "addphone/{id}", method = RequestMethod.GET)
//	public ModelAndView addphone(@PathVariable("id") Long id, HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mav;
//
//		Employee employee = employeeService.findOne(id);
//		if (employee == null) {
//			System.out.println("Employee con id " + id + "no existe");
//			mav = new ModelAndView("viewemployees");
//		} else {
//			mav = new ModelAndView("addphone");
////			mav.addObject("employee", employee);
////			mav.addObject("newPhone", new Phone());
//			Phone phone = new Phone();
//			phone.setEmployee(employee);
//			mav.addObject("newPhone", phone);
//		}
//		return mav;
//	}

//	@GetMapping("/addphone/{id}")
//	public String crear(@PathVariable(value = "id") Long id, Map<String, Object> model,
//			RedirectAttributes flash) {
//
//		Employee employee = employeeService.findOne(id);
//
//		if (employee == null) {
//			System.out.println("Employee con id " + id + "no existe");
//			return "redirect:/";
//		}
//		
//		Phone phone= new Phone();
//		model.put("newPhone", phone);
//
//		return "addphone";
//}



//	@RequestMapping(value = "/addphone", method = RequestMethod.POST)
//	public String registerProduct(HttpServletRequest request, HttpServletResponse response,
//			@ModelAttribute("newPhone") Phone newPhone,
//			RedirectAttributes flash, Model model) {
//	
////		if(employee==null) {
////			System.out.println("employee es nulo");
////		}
////		else {
////			System.out.println("employee NO es nulo");
////			System.out.println(employee.getName());
////		}
//		
//		System.out.println(newPhone.getEmployee().getName());
//		
//		//newPhone.setEmployee(employeeService.findOne(1L));
//		employeeService.savePhone(newPhone);
//		System.out.println("entre");
//		return "redirect:/";
//	}

	@RequestMapping(value = "addphone/{id}", method = RequestMethod.GET)
	public ModelAndView addphone(@PathVariable("id") Long id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav;

		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			System.out.println("Employee con id " + id + "no existe");
			mav = new ModelAndView("viewemployees");
		} else {
			mav = new ModelAndView("addphone");
			mav.addObject("newPhone", new Phone());
			mav.addObject("id", id);
		}
		return mav;
	}
	
	@RequestMapping(value = "/addphone/{id}", method = RequestMethod.POST)
	public String registerProduct(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newPhone") Phone newPhone, RedirectAttributes flash, Model model) {

		Employee employee = employeeService.findOne(id);
		Phone phone= new Phone();
		if (employee == null) {
			System.out.println("employee con id" + id + "es nulo");
		} else {
			//newPhone.setEmployee(employee);
			//employeeService.savePhone(newPhone);
			phone.setEmployee(employee);
			phone.setPhoneNumber(newPhone.getPhoneNumber());
			employeeService.savePhone(phone);
		}
		return "redirect:/";
	}

}
