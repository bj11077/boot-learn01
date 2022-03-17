package com.fertilizer.back.elastic.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.fertilizer.back.elastic.repository")
public class ElasticConfig {

    @Value("${spring.elastic.server}")
    private String server;

    @Bean
    public RestHighLevelClient client(){
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(server)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate(){
        return new ElasticsearchRestTemplate(client());
    }



}
