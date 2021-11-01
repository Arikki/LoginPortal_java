package com.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portal.entity.MemberProfile;

@Repository
public interface MemberProfileRepository extends MongoRepository<MemberProfile, String> {
	
	

}
