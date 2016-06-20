package com.nixmash.springdata.solr.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@PropertySource("classpath:solr.properties")
@ConfigurationProperties(prefix="solr")
public class SolrSettings {

	@Value("${vcap.services.MySolrInstance.credentials.SolrEndpoint}")
	private String solrServerUrl;
	private String solrEmbeddedPath;

	public String getSolrServerUrl() {
		return solrServerUrl;
	}

	public void setSolrServerUrl(String solrServerUrl) {
		this.solrServerUrl = solrServerUrl;
	}

	public String getSolrEmbeddedPath() {
		return solrEmbeddedPath;
	}

	public void setSolrEmbeddedPath(String solrEmbeddedPath) {
		this.solrEmbeddedPath = solrEmbeddedPath;
	}
	
}