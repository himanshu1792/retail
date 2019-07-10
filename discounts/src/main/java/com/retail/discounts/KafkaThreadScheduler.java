package com.retail.discounts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class KafkaThreadScheduler {

	@Bean("kafkaConsumerThreadScheduler")
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");

		//threadPoolTaskScheduler.scheduleAtFixedRate(new KafkaConsumerCreator(), 2000);

		return threadPoolTaskScheduler;
	}

}
