
package org.jsp.EmpDeptApp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int employeeID;
	private String name;
	private String email;
	private long phone;
	private String password;
	@ManyToOne
	@JoinColumn(name="dept_id")
	@JsonIgnore
	private Department dept;
	

}
