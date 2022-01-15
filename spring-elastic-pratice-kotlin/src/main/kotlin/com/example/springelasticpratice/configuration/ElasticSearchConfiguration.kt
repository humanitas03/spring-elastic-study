package com.example.springelasticpratice.configuration

import org.elasticsearch.client.RestHighLevelClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.RestClients
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@EnableElasticsearchRepositories
@Configuration
class ElasticSearchConfiguration(
    @Value("\${elasticsearch.url}") val uri: String,
) : AbstractElasticsearchConfiguration() {
    override fun elasticsearchClient(): RestHighLevelClient {
        return ClientConfiguration.builder()
            .connectedTo(uri)
            .build().run {
                RestClients.create(this).rest()
            }
    }
}
