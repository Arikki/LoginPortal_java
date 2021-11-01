package com.portal.service;

import com.portal.entity.ClaimDetails;
import com.portal.error.InvalidDataException;

public interface ClaimDetailsService {
	
	public ClaimDetails addClaimDetails(ClaimDetails request) throws InvalidDataException ;

}
