package com.interview.backbase.tinyurl.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.interview.backbase.tinyurl.entities.URLMapping;

public interface URLMappingRepository extends JpaRepository<URLMapping, Long> {
	
	Optional<URLMapping> findByTinyURL(String tinyURL);
	 
	 @Modifying
	 @Query("delete from URLMapping um where um.creationTimeStamp< :timestamp")
	 void deleteURLBeforeTimeStamp(LocalDateTime timestamp);
	
	

}
