package com.example.producerservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
	int id;
	String description;
	Date date;
	Client client;
}
