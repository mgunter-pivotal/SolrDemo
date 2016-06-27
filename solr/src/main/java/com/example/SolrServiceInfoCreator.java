package com.example;


	import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;
import org.springframework.cloud.service.ServiceConnectorCreator;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
	public class SolrServiceInfoCreator extends CloudFoundryServiceInfoCreator<SolrServiceInfo> {

	    public static final String MySolrID = "MySolrInstance";

	   
	    public SolrServiceInfoCreator() {
			// the literal in the tag is CloudFoundry-specific
			super(new Tags("simple"), "simple", "shared");
		}

	    @Override
	    public SolrServiceInfo createServiceInfo(Map<String, Object> serviceData) {
	        String id = (String) serviceData.get("name");
	        System.out.println("ID IS >>>" +id);

	        Map<String, Object> credentials = getCredentials(serviceData);
	        String uri = credentials.get("SolrEndpoint").toString();
	        System.out.println("Credentials are >>>" +credentials.toString());

	        return new SolrServiceInfo("MySolrInstance", credentials);
	    }
	    
	   
	    public boolean accept(ServiceConnectorCreator<?, ? extends ServiceInfo> creator, Class<?> serviceConnectorType,
	    		ServiceInfo serviceInfo) {
	    	System.out.println("In ACCEPT!!!!");

	    	
			boolean typeBasedAccept = serviceConnectorType == null ||
	                serviceConnectorType.isAssignableFrom(creator.getServiceConnectorType());
			boolean infoBasedAccept = serviceInfo == null ||
	                creator.getServiceInfoType().isAssignableFrom(serviceInfo.getClass());

			//return typeBasedAccept && infoBasedAccept;
			return true;
		}
	    
	    
	}