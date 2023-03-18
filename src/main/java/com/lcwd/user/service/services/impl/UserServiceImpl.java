package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lcwd.user.service.entites.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.service.entites.User;
import com.lcwd.user.service.exception.ResourceNotFountException;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserServices;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemp;



	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {

		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	//get single user
	@Override
	public User getUser(String userId) {
		//get user from database with the hlp of user repository
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFountException("User with given not found on server"+ userId));
	//fetch rating of the above user from rating service
		//http://localhost:8083/ratings/users/959d6832-73de-4c2f-add8-3aae982aa42b
	ArrayList<Rating> ratingOfUser =	restTemp.getForObject("http://localhost:8083/ratings/users/" +user.getUserId(), ArrayList.class);
        logger.info("{} ", ratingOfUser);
		user.setRatings(ratingOfUser);
		return user;
	}

}
