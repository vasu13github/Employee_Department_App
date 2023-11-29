package org.jsp.EmpDeptApp.dao;

import java.util.Optional;

import org.jsp.EmpDeptApp.dto.Department;
import org.jsp.EmpDeptApp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDao {
	@Autowired
	private DepartmentRepository repository;
	
	public Department saveDepartment(Department dept)
	{
		return repository.save(dept);
	}
	
	public Department updateDepartment(Department dept)
	{
		return repository.save(dept);
	}
	public Optional<Department> findById(int id)
	{
		return repository.findById(id);
	}
	public void deleteUser(int id)
	{
		repository.deleteById(id);
	}
	

}
