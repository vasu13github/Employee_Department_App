package org.jsp.EmpDeptApp.repository;

import org.jsp.EmpDeptApp.dto.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
