package com.example;





import com.example.SolrServiceInfo;
import com.example.SolrRepository;
import com.nixmash.springdata.solr.common.SolrSettings;

import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class SolrSettingsConnectionCreator extends AbstractServiceConnectorCreator<SolrSettings, SolrServiceInfo> {
    @Override
    public SolrSettings create(SolrServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
     return new SolrSettings(serviceInfo.getSolrEndpoint());
    }
}