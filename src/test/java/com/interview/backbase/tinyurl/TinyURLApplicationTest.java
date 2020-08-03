package com.interview.backbase.tinyurl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.interview.backbase.tinyurl.controller.URLManagementController;


/**
 * Test cases for {@link TinyURLApplication}.
 */


@SpringBootTest
public class TinyURLApplicationTest {

	@Autowired
	private URLManagementController urlManagementController;
	
	/**
	 * Testing controller initialization
	 * 
	 */
	@Test
	public void testControllerInitalization() {
		
		assertNotNull(urlManagementController);
	}
	
}
