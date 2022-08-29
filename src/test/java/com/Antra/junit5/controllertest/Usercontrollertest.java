package com.Antra.junit5.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Antra.junit5.controller.Usercontroller;
import com.Antra.junit5.service.User;
import com.Antra.junit5.service.Userservice;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value=Usercontroller.class)
public class Usercontrollertest {
	
	@MockBean
	Userservice service;
	
	@Autowired
	MockMvc mockmvc;
	
	@Test
	public void getwelcometest() {
		try {
		when(service.getwelcome()).thenReturn("welcome to world space station");
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/api/welcome");
		
			MvcResult result=mockmvc.perform(request).andReturn();
			int status=result.getResponse().getStatus();
			assertEquals(200,status);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void addusertest() {
		User user=new User();
		user.setUsername("prem");
		user.setId(191);
		user.setSal(2345.98);
		user.setDeptno("cse");
		
		when(service.adduser(any())).thenReturn(true);
		ObjectMapper mapper=new ObjectMapper();
		try {
			String userjson=mapper.writeValueAsString(user);
			MockHttpServletRequestBuilder request=MockMvcRequestBuilders.post("/api/add/user")
					.contentType("application/json")
					.content(userjson);
			MvcResult result=mockmvc.perform(request).andReturn();
			String actual=result.getResponse().getContentAsString();
			assertEquals("user add", actual);
		}
		catch(Exception e) {
			
		}
	}

}
