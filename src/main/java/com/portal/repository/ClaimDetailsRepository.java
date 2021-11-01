package com.portal.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.portal.entity.ClaimDetails;

public interface ClaimDetailsRepository extends MongoRepository<ClaimDetails, String>{
	

}
