package com.Antra.junit5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Antra.junit5.service.User;
import com.Antra.junit5.service.Userservice;

@RestController
@RequestMapping("/api")
public class Usercontroller {
	
	@Autowired
	Userservice service;
	
	@GetMapping("/welcome")
	public ResponseEntity<?> getwelcomertospace(){
		String result=service.getwelcome();
		ResponseEntity<String> entity=new ResponseEntity<String>(result,HttpStatus.OK);
		return entity;
		
	}
	@PostMapping(value="/add/user",consumes="application/json")
	public ResponseEntity<?> addusers(@RequestBody User user){
		boolean flag=service.adduser(user);
		if(flag) {
			return new ResponseEntity<String>("user add",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("user not added",HttpStatus.BAD_REQUEST);
		}
		
	}

}
