package com.mvcemployee.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvcemployee.app.models.dao.IEmployeeDao;
import com.mvcemployee.app.models.dao.IPhoneDao;
import com.mvcemployee.app.models.entity.Employee;
import com.mvcemployee.app.models.entity.Phone;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IEmployeeImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	@Autowired
	private IPhoneDao phoneDao;

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDao.save(employee);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAllEmployee() {
		return (List<Employee>) employeeDao.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Employee findOne(Long id) {
		return employeeDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void savePhone(Phone phone) {
		phoneDao.save(phone);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Phone> findAllPhone() {
		return (List<Phone>) phoneDao.findAll();
	}
	

}
