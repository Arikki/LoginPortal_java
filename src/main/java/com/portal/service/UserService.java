package com.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.portal.entity.AuthRequest;
import com.portal.entity.MemberProfile;
import com.portal.entity.Users;

@Service
public class UserService implements UserDetailsService {
    
	private List<Users> usersList;
	
	@Autowired
	private AuthProfileService authProfileSvc;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		if (username.equals("abc@gmail.com")) {
//		return new User ("abc@gmail.com", "Arikki@01", new ArrayList<>());
//		}
//		else  {
//			System.out.println("UserNameNotFound+++++++++");
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		
		
		AuthRequest authDetails = authProfileSvc.getAuthDetails(username,true);
		
		
		
		
		return new User(authDetails.getEmail(),authDetails.getPassword(),new ArrayList<>());
		
		
//		Users matchedUser=null;
//		for (Users user:usersList) {
//			if (username.equals(user.getEmail())) {
//				matchedUser = user;
//			}
//			else  {
//				throw new UsernameNotFoundException("User not found with username: " + username);
//			}
//		}
//		return new User (matchedUser.getEmail(), matchedUser.getPassword(), new ArrayList<>());
		
	}

}
