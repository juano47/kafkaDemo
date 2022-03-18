package com.example.producerservice.Controller;

import com.example.producerservice.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/messages")
public class MessageController {

	@Qualifier("orderKafkaTemplate")
	private KafkaTemplate<String, Order> kafkaTemplate;

	public MessageController(KafkaTemplate<String, Order> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@PostMapping
	public void publish(@RequestBody Order order){
		kafkaTemplate.send("kafkaTest", order);

	}
}
