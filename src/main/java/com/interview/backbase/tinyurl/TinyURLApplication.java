package com.interview.backbase.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * This is starter  class for the tiny URL conversion application
 * 
 * 
 */


@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling

public class TinyURLApplication {

	public static void main(String[] args) {
        SpringApplication.run(TinyURLApplication.class, args);
    }
}
