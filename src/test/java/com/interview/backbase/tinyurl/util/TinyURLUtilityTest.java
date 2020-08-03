package com.interview.backbase.tinyurl.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TinyURLUtilityTest {

	@Test
	public void testSpecialCharacterFilteringFromURL() {
		String url="https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json#38";
		assertTrue(url.contains("#"));
		assertFalse(TinyURLUtility.filterSpecialCharacterFromURL(url).contains("#"));
	}
	
	@Test
	public void testSpecialCharacterWhenNoSpecialCharacter() {
		String url="https://stash.backbase.com/projects/PO/repos/payment-order-integration-spec/browse/src/main/resources/schemas/definitions.json";
		assertFalse(url.contains("#"));
		assertFalse(TinyURLUtility.filterSpecialCharacterFromURL(url).contains("#"));
	}
	@Test
	public void testValidURL() {
		assertFalse(TinyURLUtility.isValidURL("www.andy.com"));
		assertTrue(TinyURLUtility.isValidURL("http://www.andy.com"));
	}
	
	@Test
	public void testBase62Conversion() {
		assertEquals("bN", TinyURLUtility.convertIntoBase62(101l));
		assertEquals("bM", TinyURLUtility.convertIntoBase62(100l));
		assertEquals("dp", TinyURLUtility.convertIntoBase62(201l));
		assertEquals("gD", TinyURLUtility.convertIntoBase62(401l));
	}
}
