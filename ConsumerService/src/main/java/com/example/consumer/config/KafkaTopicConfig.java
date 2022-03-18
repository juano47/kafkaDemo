package com.example.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	/*Configuring Topics:
	we need to ran command-line tools to create topics in Kafka,
	but with the introduction of AdminClient in Kafka, we can now create topics programmatically.
	 */
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("kafkaTest").build();
	}
}