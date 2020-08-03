package com.interview.backbase.tinyurl.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.interview.backbase.tinyurl.exception.RecordNotFoundException;

public class URLConverterTest {

	@Test
	public void testconvertAndSaveURL() {
		String url="https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		String tinyURL=URLConverter.convertAndSaveURL(url);
		assertEquals("bM",tinyURL);
	}
	
	@Test
	public void testfetchOriginalURLFromtinyURL() {
		String url="https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json";
		String tinyURL=URLConverter.convertAndSaveURL(url);
		assertEquals("bN",tinyURL);
		
		assertEquals(url,URLConverter.covertTinyURLToOriginal(tinyURL));
	}

	@Test
	public void testRecordNotFoundException() {
		
		Exception exception = assertThrows(RecordNotFoundException.class,()->{ URLConverter.covertTinyURLToOriginal("TEST");});
		assertEquals(exception.getMessage(), "Mapping for tinyURL to original not found");
	}
}
