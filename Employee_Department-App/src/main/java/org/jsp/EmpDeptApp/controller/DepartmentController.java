package org.jsp.EmpDeptApp.controller;

import org.jsp.EmpDeptApp.dto.Department;
import org.jsp.EmpDeptApp.dto.ResponseStructure;
import org.jsp.EmpDeptApp.service.DepartmentService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@CrossOrigin
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	@PostMapping("/dept")
	public ResponseEntity<ResponseStructure<Department>> saveDepartment(@RequestBody Department department)
	{
		return service.saveDepartmenet(department);
	}
	@PutMapping("/dept")
	public ResponseEntity<ResponseStructure<Department>> updateDepartment(@RequestBody Department department)
	{
		return service.updateDepartmenet(department);
	}
	@GetMapping("/dept/{id}")
	public ResponseEntity<ResponseStructure<Department>> findById(@PathVariable int id)
	{
		return service.findById(id);
	}
	
	@DeleteMapping("/dept/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteDept(@PathVariable int id)
	{
		return service.deleteDepartment(id);
	}
	

}
