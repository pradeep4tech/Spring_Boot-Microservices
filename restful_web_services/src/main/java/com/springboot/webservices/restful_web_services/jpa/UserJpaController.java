package com.springboot.webservices.restful_web_services.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.webservices.restful_web_services.bean.PostBean;
import com.springboot.webservices.restful_web_services.bean.UserBean;
import com.springboot.webservices.restful_web_services.exception.UserNotfoundException;
import com.springboot.webservices.restful_web_services.jpaentitty.PostEntitty;
import com.springboot.webservices.restful_web_services.jpaentitty.UserEntitty;
import com.springboot.webservices.restful_web_services.jparepository.PostRepository;
import com.springboot.webservices.restful_web_services.jparepository.UserRepository;
import com.springboot.webservices.restful_web_services.service.UserService;

@RestController("/jpa")
public class UserJpaController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/createUser/{id}")
	public Optional<UserEntitty> findByUserId(@PathVariable Integer id) throws UserNotfoundException
	{
		Optional<UserEntitty> userEntitty=userRepository.findById(id);
		if(userEntitty==null)
			throw new UserNotfoundException(id+"-Id");
		
		/*
		 * EntityModel<UserEntitty> entityModel=EntityModel.of(userEntitty.get());
		 * WebMvcLinkBuilder linkTO= linkTo(methodOn(this.getClass()).listUsers());
		 * entityModel.add(linkTO.withRel("Users"));
		 */
		return userEntitty;
	}
	
	@GetMapping("/users/{id}/posts")
	public Optional<PostEntitty> findUserPostsById(@PathVariable Integer id) throws UserNotfoundException
	{
		Optional<PostEntitty> postEntitty=postRepository.findById(id);
		if(!postEntitty.isPresent())
			throw new UserNotfoundException("Post Not found"+id+"-Id");
		
		/*
		 * EntityModel<PostEntitty> entityModel=EntityModel.of(postEntitty.get());
		 * WebMvcLinkBuilder linkTO= linkTo(methodOn(this.getClass()).listUsers());
		 * entityModel.add(linkTO.withRel("all-users"));
		 */
		 
		return postEntitty;
	}
	
	
	@GetMapping("/listofUsers")
	public List<UserEntitty> listUsers()
	{
		return userRepository.findAll();
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody UserBean userBean)
	{
		UserEntitty userEntitty=new UserEntitty();
		BeanUtils.copyProperties(userBean, userEntitty);
		UserEntitty userBean2= userRepository.save(userEntitty);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean2.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/users/{id}/createPost")
	public ResponseEntity<Object> createUserPost(@PathVariable Integer id,@RequestBody PostBean postBean) throws UserNotfoundException
	{
		Optional<UserEntitty> userEntitty=userRepository.findById(id);
		if(!userEntitty.isPresent())
			throw new UserNotfoundException(id+"-Id");

		PostEntitty postEntitty=new PostEntitty();
		BeanUtils.copyProperties(postBean, postEntitty);
		postEntitty.setUserEntitty(userEntitty.get());
		
		PostEntitty userBean2= postRepository.save(postEntitty);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userBean2.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	

}
