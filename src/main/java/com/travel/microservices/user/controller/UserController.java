package com.travel.microservices.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.travel.microservices.user.exception.RecordNotFoundException;
import com.travel.microservices.user.model.UserEntity;
import com.travel.microservices.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userservice;
	  private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllEmployees() {
        List<UserEntity> list = userservice.getAllEmployees();
 
        return new ResponseEntity<List<UserEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
	
	  @PostMapping("/insert")
	    public ResponseEntity<UserEntity> createOrUpdateUser(@RequestBody UserEntity user)
	                                                    throws RecordNotFoundException {
		 
		 LOG.debug("/Users response for controller: {}", user);
		 UserEntity updated = userservice.createOrUpdateUser(user);
	        return new ResponseEntity<UserEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	   @GetMapping("/{id}")
	    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
		 UserEntity entity = userservice.getUserById(id);
	 
	        return new ResponseEntity<UserEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	    }
}
