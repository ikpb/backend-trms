package com.ikpb.service.impl;

import java.util.List;

import com.ikpb.dao.UserDAO;
import com.ikpb.dao.impl.UserDaoImpl;
import com.ikpb.domain.User;
import com.ikpb.service.UserService;

public class UserServiceImpl implements UserService {
	UserDAO userDao = new UserDaoImpl();
	@Override
	public void createUser(User user) {
		userDao.createUser(user);

	}

	@Override
	public User editUser(int userid) {
		
		return userDao.editUser(userid);
	}

	@Override
	public void deleteUser(int userid) {
		userDao.deleteUser(userid);

	}

	@Override
	public User getUserById(int userid) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userid);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
