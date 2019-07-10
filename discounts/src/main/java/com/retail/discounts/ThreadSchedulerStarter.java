package com.retail.discounts;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class ThreadSchedulerStarter {
	
	
	@Autowired
	@Qualifier(value="kafkaConsumerThreadScheduler")
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
	@PostConstruct
	public void init() {
		
		KafkaConsumerCreator kafkaConsumerCreator =  new KafkaConsumerCreator();
		
		threadPoolTaskScheduler.scheduleAtFixedRate(kafkaConsumerCreator,20000);
		
	}

}
