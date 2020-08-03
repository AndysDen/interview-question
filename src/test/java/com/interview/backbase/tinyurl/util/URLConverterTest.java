package com.interview.backbase.tinyurl.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
@SpringBootTest
public class URLConverterTest {

	@Autowired
	URLConverter urlconverter;
	
	@Test
	@DirtiesContext
	public void testconvertAndSaveURL() {
		String url = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		String tinyURL = urlconverter.convertURL(url);
		assertEquals("bM", tinyURL);
	}

	@Test
	@DirtiesContext
	public void testfetchOriginalURLFromtinyURL() {
		String url = "https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json";
		String tinyURL = urlconverter.convertURL(url);
		assertEquals("bM", tinyURL);
	}

}
