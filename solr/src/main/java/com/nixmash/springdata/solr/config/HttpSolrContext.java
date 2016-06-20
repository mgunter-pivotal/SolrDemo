package com.nixmash.springdata.solr.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.server.support.HttpSolrServerFactoryBean;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nixmash.springdata.solr.common.SolrSettings;
import com.nixmash.springdata.solr.repository.SolrServer;
import com.nixmash.springdata.solr.repository.simple.SimpleProductRepository;



@Configuration
public class HttpSolrContext implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Value("${vcap.services.MySolrInstance.credentials.SolrEndpoint}")
	String solrEndpoint;
	
	@Autowired
	private SolrSettings solrSettings;

	
	
	@Bean(name = "solrServer")
	public HttpSolrServerFactoryBean solrServerFactoryBean() {
		
		HttpSolrServerFactoryBean factory = new HttpSolrServerFactoryBean();
		factory.setUrl(solrSettings.getSolrServerUrl());
		System.out.println("here is what env1 has"+ solrEndpoint);
		return factory;
	}

	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		return new SolrTemplate(solrServerFactoryBean().getObject());
	}

	@Bean
	public SimpleProductRepository simpleRepository() throws Exception {
		SimpleProductRepository simpleRepository = new SimpleProductRepository();
		simpleRepository.setSolrOperations(solrTemplate());
		return simpleRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		ConfigurableEnvironment env= event.getEnvironment();
		System.out.println("here is what env2 has in the listener"+ env.getProperty("vcap.services.mysolr.credentials.solrendpoint"));
	 
		
	}

	
	


}
