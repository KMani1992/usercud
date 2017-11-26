package com.user.cud.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.cud.service.UserCUDService;
import com.user.cud.util.UserCUDResponse;
import com.user.model.User;

@RestController
@RequestMapping("/users")
public class UserCUDController {

	@Autowired
	private UserCUDService usrCRDService;
		
	@RequestMapping(method=RequestMethod.POST,value= "/createUser")
	public @ResponseBody UserCUDResponse createUser(@RequestBody User user)
	{
		return usrCRDService.createUser(user);		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/updateUser")
	public @ResponseBody UserCUDResponse updateUser(
			@RequestParam("userID") String userID,
			@RequestParam("pinCode") long pinCode,
			@RequestParam("birthDate") Date birthDate)
	{
		return usrCRDService.updateUser(userID, pinCode, birthDate);			
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/deleteUser")
	public @ResponseBody UserCUDResponse deleteUser(@RequestParam("userID") String userID)
	{
		System.out.println("delete " + userID);
		return usrCRDService.deleteUser(userID);
		
	}
	
	@RequestMapping("/test")
	public void test(){
		System.out.println("Hello");
	}
}
