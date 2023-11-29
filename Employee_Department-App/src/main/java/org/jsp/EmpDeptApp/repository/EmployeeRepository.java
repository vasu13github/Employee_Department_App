package org.jsp.EmpDeptApp.repository;


import java.util.List;
import java.util.Optional;

import org.jsp.EmpDeptApp.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	Optional<Employee> verifyByEmail(String email, String password);
	
	@Query("select e from Employee e where e.phone=?1 and e.password=?2")
	Optional<Employee> verifyByPhone(long phone, String password);
	
	@Query("select e from Employee e where e.dept.id=?1")
	List<Employee> findEmployeeByDeptId(int dept_id);
	
	
	
}
