package com.example;

import java.util.Map;

import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("MySolr")
public class SolrServiceInfo extends BaseServiceInfo {
    public SolrServiceInfo(String id, Map<String,Object> credentials) {
        super(id);
        this.SolrEndpoint = credentials.get("SolrEndpoint").toString();
    }
    
   private String SolrEndpoint;

   @ServiceProperty
public String getSolrEndpoint() {
	return SolrEndpoint;
}

public void setSolrEndpoint(String solrEndpoint) {
	SolrEndpoint = solrEndpoint;
}


}
