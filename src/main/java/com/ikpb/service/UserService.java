package com.ikpb.service;

import java.util.List;

import com.ikpb.domain.User;

public interface UserService {
	public void createUser(User User);
	public User editUser(int userid);
	public void deleteUser(int userid);
	public User getUserById(int userid);
	public User getUserByEmail(String email);
	public User getUserAuthByEmail(String email);
	public List<User> getAllUsers();

}
