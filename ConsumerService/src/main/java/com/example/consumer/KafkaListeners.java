package com.example.consumer;

import com.example.consumer.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaListeners {

	@KafkaListener(topics = "kafkaTest", groupId = "groupId", containerFactory = "kafkaListenerContainerFactory")
	public void consumeUserMessage(@Payload Order order, @Headers MessageHeaders headers) throws IOException {
		System.out.println("received data in Consumer One ="+ order.toString());
	}
}
