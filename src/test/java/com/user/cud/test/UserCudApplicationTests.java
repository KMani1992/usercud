package com.user.cud.test;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.user.cud.service.UserCUDService;
import com.user.cud.util.ResponseCodes;
import com.user.cud.util.UserCUDResponse;
import com.user.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCudApplicationTests implements ResponseCodes {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testFutureDate() 
	{
	 
		UserCUDService uService=new UserCUDService();
		
		User user=new User();
		user.setBirthDate(new Date(2017,12,13));
		user.setEmail("kmanikandangce@gmail.com");
		user.setfName("Mani");
		user.setlName("K");
		user.setPinCode(629203);
		UserCUDResponse response=uService.createUser(user);
		
		if (!response.getArrayListValError().get(0).getCode()
				.equals(INVALID_BIRTH_DATE_VALUE)){
			fail("Birth date check failed");
		}
		else{
			System.out.println("Birthdate check method OK");
			
		}
	}
	
	
	public void testUserExists(){
		
		UserCUDService uService=new UserCUDService();
		
		User user=new User();
		user.setBirthDate(new Date(2017,11,13));
		user.setEmail("kmanikandangce@gmail.com");
		user.setfName("Mani");
		user.setlName("K");
		user.setPinCode(629203);
		uService.createUser(user);
		
		UserCUDResponse response=uService.createUser(user);
		
		if (!response.getArrayListValError().get(0).getCode()
				.equals(USER_ALREADY_EXISTS)){
			fail("Duplicate user check failed");
		}
		else{
			System.out.println("Duplicate user check method OK");
			
		}
	}

}
