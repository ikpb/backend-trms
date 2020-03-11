package com.ikpb.service.impl;

import com.ikpb.dao.UserDAO;
import com.ikpb.dao.impl.UserDaoImpl;
import com.ikpb.domain.User;
import com.ikpb.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {
	
	private static UserDAO userDao = new UserDaoImpl();
	
	@Override
	public User validateUser(String email, String password) {
		User user = userDao.getUserAuthByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			
			return user;
		}
	
		return null;
	}

}
