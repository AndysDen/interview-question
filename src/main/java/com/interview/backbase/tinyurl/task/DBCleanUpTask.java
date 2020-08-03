package com.interview.backbase.tinyurl.task;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.interview.backbase.tinyurl.repository.URLMappingRepository;

@Component
public class DBCleanUpTask {

@Autowired
URLMappingRepository urlMappingRepository;

@Scheduled(cron = "${cron.expression}")
public void removeExpiredURL() {
	urlMappingRepository.deleteURLBeforeTimeStamp(LocalDateTime.now().minusMinutes(30));
}
	
}
