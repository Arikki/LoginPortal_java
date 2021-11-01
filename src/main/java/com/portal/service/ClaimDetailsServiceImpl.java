package com.portal.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.entity.ClaimDetails;
import com.portal.error.InvalidDataException;
import com.portal.repository.ClaimDetailsRepository;

@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {
	private static long id = 1000000000L;	

	@Autowired
	private ClaimDetailsRepository repository;
	
	public ClaimDetails addClaimDetails(ClaimDetails request) throws InvalidDataException {
		
		LocalDate admitDate = LocalDate.parse(request.getAdmissionDate());
		LocalDate dischrgDate  = LocalDate.parse(request.getDischargeDate());
		
		if (!admitDate.isBefore(dischrgDate)) {
			throw new InvalidDataException("Discharge date must be after admission date!");
		}
		
		request.setClaimNumber(generateClaimNumber());
	
		return repository.insert(request);
	}
	
	private long generateClaimNumber() {
	  long claimNum = 1000000000L;
	  
	 
	
	 
	return claimNum;
	}

}
