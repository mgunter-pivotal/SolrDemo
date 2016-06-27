package com.example;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nixmash.springdata.solr.common.SolrSettings;

@Configuration
@ServiceScan
public class CloudPropertiesConfig extends AbstractCloudConfig {
//public class CloudConfig extends AbstractCloudConfig {
	
//	@Value("${vcap.services.MySolr.credentials.SolrEndpoint}")
//	String solrservice;
	
	/*@Bean
    public DataSource inventoryDataSource() {
		System.out.println("getting connection");
      return connectionFactory().dataSource("MySolrInstance");
   }*/
	
	 @Bean
	   public SolrSettings solrSettings() {
		  SolrSettingsConnectionCreator rcc = new SolrSettingsConnectionCreator();
		  this.cloud().registerServiceConnectorCreator(rcc);
		 return connectionFactory().service(SolrSettings.class);
	   }

		   public CloudPropertiesConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
		   

		@Bean
		   public Properties cloudProperties() {
			   System.out.println(cloud().getServiceInfos().toString());
		       return cloud().getCloudProperties();
		   }
		
		@Bean
		   public String cloudUrl() {
			 CloudFactory cf = new CloudFactory();
			 Cloud cloud =  cf.getCloud();
			
			 
		       return cloud.getCloudProperties().getProperty("cloud.services.MySolrInstance.SolrEndpoint");
		   }
		
		}
