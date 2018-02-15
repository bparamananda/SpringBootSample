package com.nexxi.userapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexxi.userapplication.models.User;
import com.nexxi.userapplication.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/users")
	public List<User> getUsersInfo(){
		
		return service.getListOfUsers();
	}
	
	@RequestMapping("/user/add")
	public String addUser(@RequestBody User user){
		
		return service.addingUser(user);
	}
	
	@RequestMapping("/userUpdate/{id}")
	public String updateUser(@PathVariable("id") Long id, @RequestBody User user){
		
		return service.updatingUser(id, user);
	}
	
	@RequestMapping("/userDelete/{id}")
	public String deleteUser(@PathVariable("id") Long id){
		return service.deleteUser(id);
	}
}
