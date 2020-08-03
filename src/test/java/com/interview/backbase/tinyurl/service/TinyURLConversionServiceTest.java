package com.interview.backbase.tinyurl.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.interview.backbase.tinyurl.exception.RecordNotFoundException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TinyURLConversionServiceTest {

	@Autowired
	private TinyURLConversionService tinyURLConversionService;

	@Test
	@Order(1)
	public void testConvertToTinyURL() {

		String tinyURL = tinyURLConversionService.convertToTinyURL("http://testURL.com");
		assertEquals("bM", tinyURL);

	}

	@Test
	@Order(2)
	
	public void testFetchOriginalURL() {

		assertEquals("http://testURL.com", tinyURLConversionService.fetchOriginalURL("bM"));

	}

	@Test
	@Order(3)
	@DirtiesContext
	public void testFetchOriginalURLThrowsException() {
		Exception exception = assertThrows(RecordNotFoundException.class, () -> {
			tinyURLConversionService.fetchOriginalURL("abcd");
		});
		assertEquals(exception.getMessage(), "Mapping for tinyURL to original not found");

	}

}
