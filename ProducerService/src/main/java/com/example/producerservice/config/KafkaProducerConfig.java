package com.example.producerservice.config;

import com.example.producerservice.model.Order;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	//the second parameter can be a object for example: customer!!
	@Bean
	public ProducerFactory<String, Order> orderProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//use JsonSerializer class
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	//use injection dependency instead call the method: producerFactory()
	@Bean
	public KafkaTemplate<String, Order> orderKafkaTemplate(ProducerFactory<String, Order> producerFactory) {
		return new KafkaTemplate<>(producerFactory);
	}
}
