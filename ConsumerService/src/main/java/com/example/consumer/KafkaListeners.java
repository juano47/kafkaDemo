package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

	@KafkaListener(topics = "kafkaTest", groupId = "groupId")
	void listener(String data){
		System.out.println("Receive: " + data);
	}
}
