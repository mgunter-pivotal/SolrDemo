package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ServiceScan
@EnableAutoConfiguration
public class DemoApplication {

	 /*@Autowired
	    SolrRepository solrRepository;*/
	 
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
