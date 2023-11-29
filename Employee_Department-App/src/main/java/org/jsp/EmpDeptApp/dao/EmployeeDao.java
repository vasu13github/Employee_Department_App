package org.jsp.EmpDeptApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.EmpDeptApp.dto.Employee;
import org.jsp.EmpDeptApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Optional<Employee> findById(int id)
	{
		return repository.findById(id);
	}
	
	public void deleteEmployee(int id)
	{
		 repository.deleteById(id);
	}

	public Optional<Employee> verifyByEmail(String email, String password)
	{
		return repository.verifyByEmail(email, password);
	}
	
	public Optional<Employee> verifyByPhone(long phone, String password)
	{
		return repository.verifyByPhone(phone, password);
	}
	
	public List<Employee> findAll()
	{
		return repository.findAll();
	}
	
	public List<Employee> findEmployeeByDeptId(int dept_id)
	{
		return repository.findEmployeeByDeptId(dept_id);
	}
}
