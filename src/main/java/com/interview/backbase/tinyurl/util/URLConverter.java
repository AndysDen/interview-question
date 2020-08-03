package com.interview.backbase.tinyurl.util;

import org.springframework.stereotype.Component;
@Component
public class URLConverter {

	
	private  long seedValue = 100l;

	public synchronized  String convertURL(String url) {
		

		String tinyURL = TinyURLUtility.convertIntoBase62(seedValue++);
		return tinyURL;
	}
	
	

}
