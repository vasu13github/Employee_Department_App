package org.jsp.EmpDeptApp.controller;

import java.util.List;

import org.jsp.EmpDeptApp.dto.Employee;
import org.jsp.EmpDeptApp.dto.ResponseStructure;
import org.jsp.EmpDeptApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees/{dept_id}")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee, @PathVariable int dept_id)
	{
		return service.saveEmloyee(employee, dept_id);
	}
	
	@PutMapping("/employees/{dept_id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee, @PathVariable int dept_id)
	{
		return service.updateEmloyee(employee, dept_id);
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id)
	{
		return service.deleteDept(id);
	}
	@GetMapping("/employees/verifyByEmail")
	public ResponseEntity<ResponseStructure<Employee>> findByEmail(@RequestParam String email,@RequestParam String password)
	{
		return service.findByEmail(email, password);
	}

	@GetMapping("/employees/verifyByPhone")
	public ResponseEntity<ResponseStructure<Employee>> findByPhone(@RequestParam long phone,@RequestParam String password)
	{
		return service.findByPhone(phone, password);
	}
	@GetMapping("/employees/findEmployeeByDeptId")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDeptId(@PathVariable int dept_id)
	{
		return service.findEmployeeByDeptId(dept_id);
	}
}
