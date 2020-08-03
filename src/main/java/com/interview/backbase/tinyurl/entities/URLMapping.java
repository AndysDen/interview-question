package com.interview.backbase.tinyurl.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table (name="url_mapping")

public @Data class URLMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="original_url",nullable=false,columnDefinition = "TEXT")
	private String originalURL;
	
    @Column(name="tiny_url",nullable=false,columnDefinition = "TEXT",length=10)
    private String tinyURL;
    
    @Column(name="creation_timeStamp",nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime  creationTimeStamp;
    
    public URLMapping() {
    }



	public URLMapping(String originalURL, String tinyURL,LocalDateTime creationTimeStamp) {
		
		this.originalURL=originalURL;
		this.tinyURL=tinyURL;
		this.creationTimeStamp=creationTimeStamp;
		
	}
}
