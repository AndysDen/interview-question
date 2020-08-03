package com.interview.backbase.tinyurl.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.interview.backbase.tinyurl.entities.URLMapping;

@SpringBootTest
public class URLMappingRepositoryTest {

	@Autowired
	URLMappingRepository urlMappingRepository;

	@Test
	@DirtiesContext
	public void testURLMappingExist() {

		URLMapping urlMapping = urlMappingRepository.save(new URLMapping("http://testURL.com", "test",LocalDateTime.now()));
		assertEquals("http://testURL.com",
				urlMappingRepository.findByTinyURL(urlMapping.getTinyURL()).get().getOriginalURL());
	}

	@Test
	@DirtiesContext
	public void testURLMappingDoesNotExist() {
		assertFalse(urlMappingRepository.findByTinyURL("dummyURL").isPresent());
	}

}
