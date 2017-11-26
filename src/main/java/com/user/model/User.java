package com.user.model;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	/**
	 * Unique id, to be generated in Create operation
	 */
	private String id;
	/**
	 * First Name
	 */
	private String fName;
	/**
	 * Last Name
	 */
	private String lName;
	/**
	 * Email address
	 */
	private String email;
	/**
	 * Area pin code
	 */
	private long pinCode;
	/**
	 * <DD-MON-YYYY> format e.g. 02-MAR-1980
	 */
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date birthDate;
	/**
	 * true - if user is active, false - when deleted/deactivated
	 */
	private boolean active=true;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pinCode
	 */
	public long getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String toString(){
		return "ID: " + id + "fName: " + fName + ", lName: " + lName + ", birthDate: " 
	+ birthDate + ", active: " + active + ", email: " + email + ", pinCode: " + pinCode;
	}

}
