package com.interview.backbase.tinyurl.util;

import java.util.HashMap;
import java.util.Map;

import com.interview.backbase.tinyurl.exception.RecordNotFoundException;

public class URLConverter {

	private static long seedValue=100l; 
	private static Map<String,String> tinyURLMap = new HashMap<>();
	
	public synchronized static String convertAndSaveURL(String url) {
		
		      String tinyURL =TinyURLUtility.convertIntoBase62(seedValue++);		
		      tinyURLMap.put(tinyURL,url);
		      
		      return tinyURL;
	}
public synchronized static String  covertTinyURLToOriginal(String tinyURL) {
	
	  if(! tinyURLMap.containsKey(tinyURL)) throw new RecordNotFoundException("Mapping for tinyURL to original not found");
     return tinyURLMap.get(tinyURL);
}
	
}
