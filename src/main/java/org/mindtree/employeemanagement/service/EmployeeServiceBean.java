package org.mindtree.employeemanagement.service;

import java.util.Collection;

import org.mindtree.employeemanagement.model.Employee;
import org.mindtree.employeemanagement.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceBean implements EmployeeService{

	private static final Logger log=LoggerFactory.getLogger(EmployeeServiceBean.class);
    @Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee addEmployee(Employee employee){
	log.info("Inside Employee service addEmployee method");			
	 return employeeRepository.save(employee);
	 }
	@Override
	public Employee getEmployee(long id) {
		log.info("Inside Employee service getEmployee method");
		return employeeRepository.findOne(id);
	}
	@Override
	public Collection<Employee> getAllEmplyeeDetails() {
		log.info("Inside Employee service getAllEmployeeDetails method");
		return employeeRepository.findAll();
	}
	@Override
	public void deleteEmployee(long id) {
		log.info("Inside Employee service deleteEmployee method");
		employeeRepository.delete(id);		
	}
	@Override
	public Employee validateUser(String userName, String password) {
		log.info("Inside Employee service validateUser method");
		return employeeRepository.findEmployeeByUserNameAndPassword(userName, password);	
	}
}
