package com.interview.backbase.tinyurl.task;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.interview.backbase.tinyurl.entities.URLMapping;
import com.interview.backbase.tinyurl.repository.URLMappingRepository;

@SpringBootTest
class DBCleanUpTaskTest {

	@Autowired
	URLMappingRepository urlMappingRepository;
	
	@Autowired
	DBCleanUpTask dbCleanUpTask;
	
	@Transactional
	@Test
	public void testremoveExpiredURL() {
		urlMappingRepository.save(new URLMapping("http://testurl.com", "dummy", LocalDateTime.now().minusMinutes(35)));
		urlMappingRepository.save(new URLMapping("http://2testURL.com", "dummy2", LocalDateTime.now().minusMinutes(40)));
		urlMappingRepository.save(new URLMapping("http://3testURL.com", "dummy3", LocalDateTime.now().minusMinutes(10)));
		urlMappingRepository.save(new URLMapping("http://4testurl.com", "dummy4", LocalDateTime.now().minusMinutes(20)));
		dbCleanUpTask.removeExpiredURL();
		assertEquals(2, urlMappingRepository.count());
      assertNotNull(urlMappingRepository.findByTinyURL("dummy3").get());	
      assertNotNull(urlMappingRepository.findByTinyURL("dummy3").get());	
	}
}
