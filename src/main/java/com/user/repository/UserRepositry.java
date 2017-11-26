package com.user.repository;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import com.user.model.User;

public class UserRepositry {

	private static final Map<String, User> hashMapUser = new HashMap<>();

	/**
	 * API used to create the new user
	 * 
	 * @param user
	 * @return created new userId
	 */	
	public String addUser(User user) {
		String userId = createUserId();
		hashMapUser.put(userId, user);		
		return userId;
	}

	public void updateUser(String userId, User user) {
		hashMapUser.put(userId, user);
	}

	public void deleteUser(String userId) {
		hashMapUser.get(userId).setActive(false);
	}

	public User getUser(String userId) {
		return hashMapUser.get(userId);
	}

	/**
	 * API used to check if the active user exists in the same email id
	 * 
	 * @param email
	 * @return true- user exists, false - user does not exists
	 */
	public boolean isActiveUserExist(String email) {
		Iterator<String> iterator = hashMapUser.keySet().iterator();
		while (iterator.hasNext()) {
			User user = hashMapUser.get(iterator.next());
			System.out.println("active user check " + user.toString());
			if (user.isActive() && user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * API used to create the unique user ID
	 * 
	 * @return
	 */
	private synchronized String createUserId() {
		return UUID.randomUUID().toString();
	}
	
}
