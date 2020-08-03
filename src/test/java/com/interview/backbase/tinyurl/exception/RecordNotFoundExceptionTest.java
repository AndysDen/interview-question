package com.interview.backbase.tinyurl.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.interview.backbase.tinyurl.util.URLConverter;

public class RecordNotFoundExceptionTest {

	/*
	 * Test RecordNotFoundException is thrown
	 * 
	 */
	
	@Test
	public void testThrowingRecordNotFoundException() {
		
		Exception exception = assertThrows(RecordNotFoundException.class,()->{ URLConverter.covertTinyURLToOriginal("TEST");});
		assertEquals(exception.getMessage(), "Mapping for tinyURL to original not found");
	}
	
}
