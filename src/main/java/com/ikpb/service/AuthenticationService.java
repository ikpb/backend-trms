package com.ikpb.service;

import com.ikpb.domain.User;

public interface AuthenticationService {

	public User validateUser(String username, String password);

}
