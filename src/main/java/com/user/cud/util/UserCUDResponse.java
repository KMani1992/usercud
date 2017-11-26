package com.user.cud.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class UserCUDResponse {

	/**
	 * Concise response message, indicating what has happened to the request
	 */
	private String resMsg;
	/**
	 * Unique user Id, created during Create operation. 
	 */
	private String userId;
	
	/**
	 * Array - Array of UserValidationError, indicating individual validation errors
	 */	
	private final List<UserValidationError> arrayListValError; 
	
	public UserCUDResponse(){
		arrayListValError=new ArrayList<UserValidationError>();
	}
	/**
	 * @return the resMsg
	 */
	public String getResMsg() 
	{
		return resMsg;
	}
	
	/**
	 * @param resMsg the resMsg to set
	 */
	public void setResMsg(String resMsg) 
	{
		this.resMsg = resMsg;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the arrayListValError
	 */
	public List<UserValidationError> getArrayListValError() {
		return arrayListValError;
	}
	
	/**
	 * API used to add the validation error message
	 * @param code
	 * @param field
	 * @param msg
	 */
	public void addValError(String code,String field,String msg){
		UserValidationError userValErr= new UserValidationError();
		userValErr.setCode(code);
		userValErr.setField(field);
		userValErr.setMesage(msg);
		arrayListValError.add(userValErr);
	}
		
	
}
