package com.user.cud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.user.cud.util.UserCUDResponse;
import com.user.repository.UserRepositry;

@SpringBootApplication
@Configuration
public class UserCudApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCudApplication.class, args);
	}
	
	@Bean
	public UserRepositry getUserRepositry(){
		return new UserRepositry();
	}
	
	@Bean	
	public UserCUDResponse getUserCUDResponse(){
		return new UserCUDResponse();
	}
}
