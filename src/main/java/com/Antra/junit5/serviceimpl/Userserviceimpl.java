package com.Antra.junit5.serviceimpl;

import com.Antra.junit5.service.User;
import com.Antra.junit5.service.Userservice;

public class Userserviceimpl implements Userservice {

	@Override
	public String getwelcome() {
		
		return "welcome to world space station";
	}

	@Override
	public boolean adduser(User user) {
		
		return true;
	}

}
