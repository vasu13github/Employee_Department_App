package org.jsp.EmpDeptApp.exception;

public class IdNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "invalid email id or password";
	}

}
