package org.jsp.EmpDeptApp.service;

import java.util.Optional;

import org.jsp.EmpDeptApp.dao.DepartmentDao;
import org.jsp.EmpDeptApp.dto.Department;
import org.jsp.EmpDeptApp.dto.ResponseStructure;
import org.jsp.EmpDeptApp.exception.IdNotFoundException;
import org.jsp.EmpDeptApp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentService {
	@Autowired
	  private DepartmentDao Ddao;
	
	public ResponseEntity<ResponseStructure<Department>> saveDepartmenet(Department department)
	{
		ResponseStructure<Department> redept=new ResponseStructure<>();
		Ddao.saveDepartment(department);
		redept.setData(department);
		redept.setMessage("department saved with id :"+department.getId());
		redept.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Department>>(redept, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Department>> updateDepartmenet(Department department)
	{
		ResponseStructure<Department> redept=new ResponseStructure<>();
		Ddao.updateDepartment(department);
		redept.setData(department);
		redept.setMessage("department saved with id :"+department.getId());
		redept.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Department>>(redept, HttpStatus.ACCEPTED);
	}
	 public ResponseEntity<ResponseStructure<Department>> findById(int id)
	 {
		 ResponseStructure<Department> structure=new ResponseStructure<>();
		 Optional<Department> redept=Ddao.findById(id);
		 if(redept.isPresent())
		 {
			 structure.setData(redept.get());
			 structure.setMessage("user found");
			 structure.setStatusCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<Department>>(structure, HttpStatus.OK);
		 }
		throw new IdNotFoundException();
	 }
	 
	 public ResponseEntity<ResponseStructure<String >> deleteDepartment(int id)
	 {
		 ResponseStructure<String> structure=new ResponseStructure<>();
		 Optional<Department> redept=Ddao.findById(id);
		 if(redept.isPresent())
		 {
			 Ddao.deleteUser(id);
			 structure.setData("user deleted");
			 structure.setMessage("user found");
			 structure.setStatusCode(HttpStatus.OK.value());
			 return new ResponseEntity<ResponseStructure<String >>(structure,HttpStatus.OK);
		 }
		 throw new IdNotFoundException();
	 }

}
