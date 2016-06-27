package com.example;

import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	//@Autowired
	//DataSource inventoryDb;
	
	@Autowired 
	@Qualifier("cloudProperties")
	Properties properties;
	
	//@Autowired 
	//@Qualifier("cloudUrl")
	//String url;
	
   @Autowired
   SolrRepository solrRepository;
	
//	@Value("${vcap.services.MySolr.credentials.SolrEndpoint}")
//	String solrservice;
	
	
	
	@ResponseBody
	@RequestMapping(value = "/", produces = "application/json")
	public Set<String> dumpData(Model model) {
	
		Set <String> titles = new LinkedHashSet<String>();
		System.out.println(properties.toString());
		//System.out.println(url +"<<<<<<<endpoint?");
		//System.out.println("solr info>>>>>>>>>"+solrInfo.getUri());
		//System.out.println(inventoryDb.toString());
		System.out.println(solrRepository.solrEndpoint);

		// To display complete Product Name field in dropdown ----------------------------------- */
		//
		// List<Product> result = productService.getProductsByStartOfName(query);
		//
		// Set<String> titles = new LinkedHashSet<String>();
		// for (Product product : result) {
		// if (product.getName().toLowerCase().contains(query.toLowerCase())) {
		// titles.add(product.getName());
		// }
		// }

		return titles;
	}

}
