package com.hms.kafka.springbootkafkaproducersample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ShipmentResource {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "Harsha_Sample";

	@GetMapping("/publish1/{message}")
	public String postShipmentMessage1(@PathVariable("message") final String message) {
		
		kafkaTemplate.send(TOPIC, message); // Simple String Message publish
		
		return "Publish Shipment Successful";
	}
	
	@GetMapping("/publish2/{message}")
	public String postShipmentMessage2(@PathVariable("message") final String message) {
		
		
		// Need config for serializing the value.
		kafkaTemplate.send(TOPIC, message); // Object Message publish
		
		return "Publish Shipment Successful";
	}
	
}
