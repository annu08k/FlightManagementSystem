package com.cg.service;

import com.cg.bean.flightUser;
import java.math.BigInteger;
import java.util.List;

public interface UserService {
	
	//add a user
    public  flightUser addUser(flightUser u);
    
    //update user based on user id
    public flightUser updateUser(flightUser newAccount, BigInteger userId);
    
    //delete user
    public void deleteUser(BigInteger userId);
    
    //view user based on user id
    public flightUser viewUser(BigInteger userId);
    
    //view all users
    public List<flightUser> viewUser();
    
    //validate user
    public void validateUser(flightUser flightUser);
}
