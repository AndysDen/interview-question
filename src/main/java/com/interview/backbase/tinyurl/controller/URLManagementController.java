package com.interview.backbase.tinyurl.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.backbase.tinyurl.exception.RecordNotFoundException;
import com.interview.backbase.tinyurl.service.TinyURLConversionService;
import com.interview.backbase.tinyurl.util.TinyURLUtility;


@RestController
public class URLManagementController {

	
	 private static final Logger LOGGER = LoggerFactory.getLogger(URLManagementController.class);

	    @Autowired
	    private TinyURLConversionService tinyURLConverterService;

	    /**
	     * Default Constructor.
	     */
	    public URLManagementController() {
	    }

	    /**
	     *  http POST  to convert the original URL into tinyURL.
	     *
	     * @param url the Original url.
	     * @return the tinyURL.
	     */
	    @PostMapping(value = "/short")
	    public ResponseEntity<String> convertToTinyURL(@RequestParam(name = "url") String url) {

	        LOGGER.info("Received request to convert url={} to tiny expression", url);

	        if (!TinyURLUtility.isValidURL(url)) {
	            LOGGER.error("Provided URL is Incorrect url={}", url);
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Provided URL is Incorrect or Invalid");
	        }
               String filteredURL =TinyURLUtility.filterSpecialCharacterFromURL(url);
	        String tinyExpression = tinyURLConverterService.convertOriginalToTinyURL(filteredURL);
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(tinyExpression);
	    }

	    /**
	     * Handles GET requests to convert tiny expression to long url.
	     *
	     * @param tinyURL the tiny expression
	     * @return  Original url
	     */
	    @GetMapping(value = "/long")
	    public ResponseEntity<String> convertToOriginalURL(@RequestParam(name = "tiny") String tinyURL) {
	        LOGGER.info("fetching Original url for tinyURL tinyURL={}", tinyURL);
	        try {
	            String longURL = tinyURLConverterService.convertTinyToOriginalURL(tinyURL);
	            return ResponseEntity.status(HttpStatus.OK)
	                    .body(longURL);
	        } catch (RecordNotFoundException e) {
	            LOGGER.warn("Invalid tinyURL ={}", tinyURL, e);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(e.getMessage());
	        }
	    }

	   
}
