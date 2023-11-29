package org.jsp.EmpDeptApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.EmpDeptApp.dao.DepartmentDao;
import org.jsp.EmpDeptApp.dao.EmployeeDao;
import org.jsp.EmpDeptApp.dto.Department;
import org.jsp.EmpDeptApp.dto.Employee;
import org.jsp.EmpDeptApp.dto.ResponseStructure;
import org.jsp.EmpDeptApp.exception.IdNotFoundException;
import org.jsp.EmpDeptApp.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao edao;
	@Autowired
	private DepartmentDao Ddao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmloyee(Employee employee, int dept_id) {
		Optional<Department> redept = Ddao.findById(dept_id);
		ResponseStructure<Employee> emps = new ResponseStructure<>();
		if (redept.isPresent()) {
			Department d = redept.get();
			d.getEmployee().add(employee);
			Ddao.updateDepartment(redept.get());
			edao.saveEmployee(employee);
			employee.setDept(redept.get());
			emps.setData(edao.saveEmployee(employee));
			emps.setMessage("employee savedd with id ;" + employee.getId());
			emps.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(emps, HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmloyee(Employee employee, int dept_id) {
		Optional<Department> redept = Ddao.findById(dept_id);
		ResponseStructure<Employee> emps = new ResponseStructure<>();
		if (redept.isPresent()) {
			employee.setDept(redept.get());
			edao.saveEmployee(employee);
			employee.setDept(redept.get());
			emps.setData(edao.saveEmployee(employee));
			emps.setMessage("employee updated ");
			emps.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Employee>>(emps, HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findById(int id)
	{
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> emps=edao.findById(id);
		if(emps.isPresent())
		{
			structure.setData(emps.get());
			structure.setMessage("user found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<String >> deleteDept(int id)
	{
		ResponseStructure<String > structure=new ResponseStructure<>();
		Optional<Employee> emps=edao.findById(id);
		if(emps.isPresent())
		{
			edao.deleteEmployee(id);
			structure.setData("employee is deleted ");
			structure.setMessage("user found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(String email,String password)
	{
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> emps=edao.verifyByEmail(email, password);
		if(emps.isPresent())
		{
			structure.setData(emps.get());
			structure.setMessage("employee found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(long phone,String password)
	{
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		Optional<Employee> emps=edao.verifyByPhone(phone, password);
		if(emps.isPresent())
		{
			structure.setData(emps.get());
			structure.setMessage("employee found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}
	
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDeptId(int dept_id)
	{
		ResponseStructure<List<Employee>> structure=new ResponseStructure<>();
			structure.setData(edao.findEmployeeByDeptId(dept_id));
			structure.setMessage("employee found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		
	}

}
