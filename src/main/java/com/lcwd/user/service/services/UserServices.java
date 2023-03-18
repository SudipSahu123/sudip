package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entites.User;

public interface UserServices {

	//user operation
	
	//create
	User  saveUser(User user);
	
	//get All user
	List<User>getAllUser();
	

	//get single user of given userId
	User getUser(String userId);
	
}
