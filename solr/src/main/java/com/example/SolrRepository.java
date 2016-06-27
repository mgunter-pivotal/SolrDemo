package com.example;

import org.springframework.stereotype.Repository;


@Repository
	public class SolrRepository {
	
	
	public SolrRepository() {

		
		
		System.out.println("Repo Constructed");
	}
	   
	   public SolrRepository(String solrEndpoint) {
		this.solrEndpoint = solrEndpoint;
		System.out.println(solrEndpoint);
	}

	String solrEndpoint;
	    
}
