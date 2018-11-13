package com.mvcemployee.app.models.service;

import java.util.List;

import com.mvcemployee.app.models.entity.Employee;
import com.mvcemployee.app.models.entity.Phone;

public interface IEmployeeService {
	public void saveEmployee(Employee employee);
	public void savePhone(Phone phone);
	public List<Employee> findAllEmployee();
	public List<Phone> findAllPhone();
	public Employee findOne(Long id);
}
