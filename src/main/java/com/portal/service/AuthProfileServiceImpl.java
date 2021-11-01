package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;
import com.portal.entity.AuthRequest;
import com.portal.entity.MemberProfile;
import com.portal.repository.AuthProfileRepository;

@Service
public class AuthProfileServiceImpl implements AuthProfileService {
	
	@Autowired
	private AuthProfileRepository repository;
	
@Autowired
	private BCryptPasswordEncoder encoder;
	

	public AuthRequest addAuthDetails(AuthRequest request) {
		
		request.setPassword(encoder.encode(request.getPassword()));
		System.out.println(request.toString());
		
		return repository.insert(request);
		
		
	}

	public AuthRequest getAuthDetails(String email, boolean internalCall) {
		System.out.println("Inside get Auth details() ==>"+ email);	
		AuthRequest authDetails= repository.findById(email).get();
		
		if(!internalCall) {
			authDetails.setPassword("");
		}
		return authDetails;
	}
}
