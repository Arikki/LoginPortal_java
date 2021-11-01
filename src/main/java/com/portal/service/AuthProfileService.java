package com.portal.service;

import com.portal.entity.AuthRequest;
import com.portal.entity.MemberProfile;

public interface AuthProfileService {

	public AuthRequest addAuthDetails(AuthRequest request);
	public AuthRequest getAuthDetails (String email, boolean internalCall);
	
}
