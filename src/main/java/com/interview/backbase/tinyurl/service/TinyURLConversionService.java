package com.interview.backbase.tinyurl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.backbase.tinyurl.entities.URLMapping;
import com.interview.backbase.tinyurl.exception.RecordNotFoundException;
import com.interview.backbase.tinyurl.repository.URLMappingRepository;
import com.interview.backbase.tinyurl.util.URLConverter;

/*
 * Service class used to convert Original URL into tiny URL and vice versa.
 * To keep tinyURL generation simple we have take this problem as Base10 to base 62 conversion.
 * 
 */
@Service
public class TinyURLConversionService {

	@Autowired
	URLMappingRepository urlMappingRepository;
	@Autowired
	URLConverter urlConverter;

	public String convertToTinyURL(String originalURL) {

		String tinyURL = urlConverter.convertURL(originalURL);
		URLMapping urlMapping = new URLMapping(originalURL, tinyURL);
		urlMappingRepository.save(urlMapping);
		return tinyURL;
	}

	public String fetchOriginalURL(String tinyURL) {
      URLMapping urlMapping = urlMappingRepository.findByTinyURL(tinyURL)
				.orElseThrow(() -> new RecordNotFoundException("Mapping for tinyURL to original not found"));
		return urlMapping.getOriginalURL();
	}

}
