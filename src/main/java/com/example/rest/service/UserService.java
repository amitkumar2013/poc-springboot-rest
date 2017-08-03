package com.example.rest.service;

import com.example.rest.model.User;

public interface UserService {

	User getUser(int id);

	User createUser(User user);

}
