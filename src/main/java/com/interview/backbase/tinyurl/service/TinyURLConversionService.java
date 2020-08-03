package com.interview.backbase.tinyurl.service;

import org.springframework.stereotype.Service;

import com.interview.backbase.tinyurl.util.URLConverter;

/*
 * Service class used to convert Original URL into tiny URL and vice versa.
 * To keep tinyURL generation simple we have take this problem as Base10 to base 62 conversion.
 * 
 */
@Service
public class TinyURLConversionService {

	
	
	public String convertOriginalToTinyURL(String originalURL) {
		 
		         return URLConverter.convertAndSaveURL(originalURL);
	}

	public String convertTinyToOriginalURL(String tinyURL) {
		
		return  URLConverter.covertTinyURLToOriginal(tinyURL);
	}

}
