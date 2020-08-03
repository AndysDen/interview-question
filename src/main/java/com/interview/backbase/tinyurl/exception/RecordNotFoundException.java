package com.interview.backbase.tinyurl.exception;


/*
 * This exception is thrown when lookup for tiny URL to Original URL fails.
 */

public class RecordNotFoundException extends RuntimeException {
    
	
	
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String msg) {
        super(msg);
    }
	
	
}
