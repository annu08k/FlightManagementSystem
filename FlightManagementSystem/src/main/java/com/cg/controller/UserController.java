package com.cg.controller;

import com.cg.bean.flightUser;
import com.cg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    
    /*
     URI : http://localhost:8085/user/showAllUsers
     METHOD : GET
     */
    @GetMapping("/showAllUsers")
    public List<flightUser> showAllUser(){
        List<flightUser> list =userService.viewUser();
        return  list;
    }
    
    /*
     URI : http://localhost:8085/user/addUser
     METHOD : POST
     {
  		"email": "lakshya@gmail.com",
  		"id": 1,
  		"userName": "Lakshya",
  		"userPassword": "lakshya",
  		"userPhone": 1234567894,
  		"userType": "customer"
	}
     */
    @PostMapping("/addUser")
    public flightUser newUser(@RequestBody flightUser flightUser){
    	userService.validateUser(flightUser);
        return  userService.addUser(flightUser);
    }
    
    /*
     URI : http://localhost:8085/user/showById/15
     METHOD : GET
     */
    @GetMapping("/showById/{userId}")
    public flightUser showById(@PathVariable BigInteger userId){
    	
        return  userService.viewUser(userId);
    }
    
    /*
     URI : http://localhost:8085/user/modifyUser/15
     METHOD : PUT
     {
  		"email": "ram@gmail.com",
  		"id": 11,
  		"userName": "Ram",
  		"userPassword": "ram",
  		"userPhone": 1234567895,
  		"userType": "admin"
	}
     */
    @PutMapping("/modifyUser/{userId}")
    public flightUser updateUser(@RequestBody flightUser newU,@PathVariable BigInteger userId){
    	
    	userService.validateUser(newU);
        return userService.updateUser(newU,userId);
    }
    
    /*
     URI : http://localhost:9001/user/deleteUser/13
     METHOD : DELETE
     */
    @DeleteMapping("/deleteUser/{userId}")
    public  void deleteUser(@PathVariable String userId){
    	
        userService.deleteUser(new BigInteger(userId));
    }
    
    
 		
}
