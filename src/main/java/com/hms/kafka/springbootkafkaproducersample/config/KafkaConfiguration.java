package com.hms.kafka.springbootkafkaproducersample.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.hms.kafka.springbootkafkaproducersample.model.Shipment;



@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String,Shipment> producerFactory() {
		
		Map<String, Object> config = new HashMap<>();
		// Config where Zoo keeper is running and where we have our Topic.
		config.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	/**
	 * Kafka Template will be loaded and uses this above config and that can be used.
	 * @return
	 */
	@Bean
	public KafkaTemplate<String, Shipment> kafkaTemplate() {
		return new KafkaTemplate<String, Shipment>(producerFactory());
		
		
	}

}
