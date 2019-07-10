package com.retail.discounts;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DiscountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscountsApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		
		return builder.setConnectTimeout(1000).setReadTimeout(1000).build();
		//SocketTimeoutException 
		//ConnectTimeoutException
		
	}
	
	
}
