package com.hms.kafka.springbootkafkaproducersample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.kafka.springbootkafkaproducersample.model.Shipment;

@RestController
@RequestMapping("kafka")
public class ShipmentResource {
	
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	KafkaTemplate<String, Shipment> kafkaTemplate;
	
	private static final String TOPIC = "Harsha_Sample";

//	@GetMapping("/publish1/{message}")
//	public String postShipmentMessage1(@PathVariable("message") final String message) {
//		
//		kafkaTemplate.send(TOPIC, message); // Simple String Message publish
//		
//		return "Publish String Message Successful";
//	}
	
	@GetMapping("/publish2/{id}")
	public String postShipmentMessage2(@PathVariable("id") final String shipmentId) {
		
		Shipment shipmentData = new Shipment();
		shipmentData.setShipmentId(shipmentId);
		shipmentData.setShipmentName("ST"+shipmentId);
		shipmentData.setSrcLocation("SRCLOC"+shipmentId);
		shipmentData.setTransportMode("TruckLoad");
		// Need config for serializing the value.
		kafkaTemplate.send(TOPIC, shipmentData); // Object Message publish
		
		return "Publish Shipment Successful";
	}
	
}
