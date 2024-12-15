package com.industry.inventory.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfiguration {

    @Value("${application.kafka.topic}")
    private String topicName;

    @Value("${application.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

    /**
     * This method will automatically create a topic with the name 
     * specified in the application.yml file.
     * 
     * @return a new topic with the configured name
     */
    @Bean
    NewTopic newTopic() {
        return TopicBuilder.name(topicName).build();
    }
    
}
