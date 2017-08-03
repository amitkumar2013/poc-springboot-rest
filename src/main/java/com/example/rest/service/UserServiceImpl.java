package com.example.rest.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.model.User;
import com.example.rest.model.UserAlreadyException;

@Service
public class UserServiceImpl implements UserService {

	private List<User> userList;

	public UserServiceImpl() {
		userList = new LinkedList<>();
		userList.add(new User(1, "Peter", 25));
		userList.add(new User(2, "Pan", 30));
	}

	@Override
	public User getUser(int id) {
		return userList.stream().filter(user1 -> user1.getId() == id).findFirst().orElse(null);
	}

	@Override
	public User createUser(User user) {
		User existingUser = getUser(user.getId());
		if (existingUser != null) {
			throw new UserAlreadyException("User already exists for id " + user.getId());
		}
		userList.add(user);
		return getUser(user.getId());
	}

}
