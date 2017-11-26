package com.user.cud.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.cud.util.ResponseCodes;
import com.user.cud.util.UserCUDResponse;
import com.user.model.User;
import com.user.repository.UserRepositry;

@Service
public class UserCUDService implements ResponseCodes {

	@Autowired
	private UserRepositry userRepository;
		
	
	
	public UserCUDResponse createUser(User user){
	
		UserCUDResponse usrCUDRes=new UserCUDResponse();
		if(isValidBirthDate(user.getBirthDate()))
		{
			if(!userRepository.isActiveUserExist(user.getEmail()))
			{
				String userId=userRepository.addUser(user);
				System.out.println(user.toString());
				usrCUDRes.setResMsg("User Created");
				usrCUDRes.setUserId(userId);
			}
			else
			{
				usrCUDRes.setResMsg("Validation Error");
				usrCUDRes.addValError(USER_ALREADY_EXISTS, "email", "User with email " + user.getEmail() + " already exists");
			}
		
		}
		else
		{
			usrCUDRes.setResMsg("Validation Error");
			usrCUDRes.addValError(INVALID_BIRTH_DATE_VALUE, "birthdate", "Birth Date " + user.getBirthDate() + " cant be future date");
		}
		return usrCUDRes;
	}
	
	public UserCUDResponse updateUser(String userID,long pinCode,Date birthDate){
		UserCUDResponse usrCUDRes=new UserCUDResponse();
		User user=getUser(userID);		
		
		if(null!=user)
		{
			if(isValidBirthDate(user.getBirthDate()))
			{
				user.setBirthDate(birthDate);
				user.setPinCode(pinCode);
				
				System.out.println(getUser(userID).toString());
				
				usrCUDRes.setResMsg("User Updated");
				usrCUDRes.setUserId(userID);
			}
			else
			{
				usrCUDRes.setResMsg("Validation Error");
				usrCUDRes.addValError(INVALID_BIRTH_DATE_VALUE, "birthdate", "Birth Date " + user.getBirthDate() + " cant be future date");
			}
		}
		else
		{
			usrCUDRes.setResMsg("Validation Error");
			usrCUDRes.addValError(USER_DOESNOT_EXISTS, "userid", "User with id " + userID + " does not exists");
		}
		return usrCUDRes;
	}
	
	public UserCUDResponse deleteUser(String userID)
	{
		UserCUDResponse usrCUDRes=new UserCUDResponse();
		User user=getUser(userID);		
		
		if(null!=user)
		{			
			userRepository.deleteUser(userID);
			usrCUDRes.setResMsg("User Deleted");
			usrCUDRes.setUserId(userID);
		}
		else
		{
			usrCUDRes.setResMsg("Validation Error");
			usrCUDRes.addValError(USER_DOESNOT_EXISTS, "userid", "User with id " + userID + " does not exists");
		}
		
		return usrCUDRes;
	
	}
	
	/**
	 * method user to get the user
	 * @param userID
	 * @return
	 */
	private User getUser(String userID){
		return userRepository.getUser(userID);
	}
	
	private boolean isValidBirthDate(Date birthDate){
		return birthDate.getTime() <= new Date().getTime();
	}	
	
}
