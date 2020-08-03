package com.interview.backbase.tinyurl.util;

import java.math.BigInteger;
import java.util.regex.Pattern;


/*
 * This class contains various util method to perform various validation and value add conversion in the application. 
 */



public class TinyURLUtility {
	
	private static String REGEX= "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private static final char[] corpus   = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    /**
     *  This method is to check if URL submitted for compression is a valid URL or not. This method expects a URL input as String 
     *  which is verified for validity based on the REGEX pattern defined. 
     * 
     * @param url the url
     * @return valid true/false.
     */
    public static boolean isValidURL(String url) {
        return Pattern.compile(REGEX).matcher(url).matches();
    }

    /*
     * This method will convert the seedValue provided from base 10 to base 62. 
     */
public static String convertIntoBase62(long seed) {
		
		String uniqValue=seed+"";
		char[] seedBuf= new char[uniqValue.length()];
		int seedIndex =  uniqValue.length()-1;
		BigInteger seedValue = new BigInteger(uniqValue);
		BigInteger base= BigInteger.valueOf(62);
		while(seedValue.compareTo(base) >=0) {
			seedBuf[seedIndex--]=corpus[seedValue.mod(base).intValue()];
			seedValue =seedValue.divide(base);
		}
		seedBuf[seedIndex]=corpus[seedValue.intValue()];
		
		return new String(seedBuf,seedIndex,(uniqValue.length()-seedIndex));
	}

/*
 * If URL will contain # then it will be removed from the URL
 */
public static String filterSpecialCharacterFromURL(String url) {
	
	   return url.contains("#")?url.substring(0,url.indexOf("#")):url;
}
}


