package com.nixmash.springdata.solr.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.cloud.config.java.CloudScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.server.support.HttpSolrServerFactoryBean;

import com.nixmash.springdata.solr.common.SolrSettings;
import com.nixmash.springdata.solr.repository.SolrServer;
import com.nixmash.springdata.solr.repository.simple.SimpleProductRepository;

@Configuration
@CloudScan
public class HttpSolrContext implements
EnvironmentAware, ApplicationListener<ApplicationEnvironmentPreparedEvent> {


	@Resource
	private Environment environment;
	
	@Autowired
	private SolrSettings solrSettings;

	
	
	@Bean(name = "solrServer")
	public HttpSolrServerFactoryBean solrServerFactoryBean() {
		HttpSolrServerFactoryBean factory = new HttpSolrServerFactoryBean();
		factory.setUrl(solrSettings.getSolrServerUrl());
		System.out.println("here is what env1 has"+ environment.getProperty("vcap.services.mysolr.credentials.solrendpoint"));
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
	public void VcapPropertyLoaderListener() {
	//	ConfigurableEnvironment env= event.getEnvironment();
		System.out.println("here is what env3 has in the listener"+ environment.getProperty("vcap.services.mysolr.credentials.solrendpoint"));
		
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.environment= environment;
		System.out.println("here is what env4 has in the listener"+ environment.getProperty("vcap.services.mysolr.credentials.solrendpoint"));
		
	}
	


}
