package com.ikpb.dao;

import java.util.List;

import com.ikpb.domain.User;

public interface UserDAO {

	public void createUser(User User);
	public User editUser(int userid);
	public void deleteUser(int userid);
	public User getUserById(int userid);
	public User getUserByEmail(String email);
	public int	getSupervisorIdByTitle(int title);
	public List<User> getAllUsers();
}
