package com.interview.backbase.tinyurl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.backbase.tinyurl.entities.URLMapping;

public interface URLMappingRepository extends JpaRepository<URLMapping, Long> {
	
	Optional<URLMapping> findByTinyURL(String tinyURL);

}
