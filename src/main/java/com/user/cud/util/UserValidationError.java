package com.user.cud.util;

public class UserValidationError {

	/**
	 * App specific validation error code
	 */
	private String code;
	/**
	 * Name of the field, that has failed validation
	 */
	private String field;
	/**
	 *  Concise validation error message, that can be displayed on front end
	 */
	private String mesage;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}
	/**
	 * @return the mesage
	 */
	public String getMesage() {
		return mesage;
	}
	/**
	 * @param mesage the mesage to set
	 */
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	
	
	
	
}
