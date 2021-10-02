package com.springboot.webservices.restful_web_services.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.webservices.restful_web_services.bean.UserBean;
import com.springboot.webservices.restful_web_services.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
/*	
	@GetMapping("/users/{id}")
	public EntityModel<UserBean> findById(@PathVariable Integer id) throws UserNotfoundException
	{
		UserBean userBean=userService.findById(id);
		if(userBean==null)
			
			throw new UserNotfoundException(id+"-Id");
		
		EntityModel<UserBean> entityModel=EntityModel.of(userBean);	
		WebMvcLinkBuilder linkTO=
		linkTo(methodOn(this.getClass()).listUsers());
		entityModel.add(linkTO.withRel("all-users"));
		
		return entityModel;
	}
	*/
	@GetMapping("/listusers")
	public List<UserBean> listUsers()
	{
		return userService.listUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean userBean)
	{
		UserBean userBean2= userService.save(userBean);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean2.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Integer id)
	{
		userService.deleteById(id);
		return ResponseEntity.status(200).build();
	}
	

}
