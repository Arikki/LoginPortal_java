package com.portal.service;

import com.portal.entity.MemberProfile;
import com.portal.entity.SignupRequest;
import com.portal.error.InvalidDataException;

public interface MemberProfileService {
	
	public MemberProfile addMemberProfile(MemberProfile profile) throws InvalidDataException;
	public MemberProfile updateMemberProfile (MemberProfile profile) throws InvalidDataException;
	public MemberProfile getMemberProfile(String email) throws InvalidDataException;
	
}
