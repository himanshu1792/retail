package com.retail.discounts;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

	/*@org.springframework.kafka.annotation.KafkaListener(id = "consumer1", groupId = "group-id", topicPartitions = {

			@TopicPartition(topic = "my-replicated-topic", partitionOffsets = @org.springframework.kafka.annotation.PartitionOffset(partition = "0", initialOffset = "0")) })
	public void listen(@Payload String message) {
		System.out.println("Received Messasge in group - group-id0: " + message);
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	     consumer.subscribe(Arrays.asList("foo", "bar"));
	}
	
	@org.springframework.kafka.annotation.KafkaListener(id = "consumer2", groupId = "group-id", topicPartitions = {

			@TopicPartition(topic = "my-replicated-topic", partitions = { "1" } ) })
	public void listen1(String message) {
		System.out.println("Received Messasge in group - group-id1: " + message);
	}
	
	@org.springframework.kafka.annotation.KafkaListener(id = "consumer5", groupId = "group-id", topicPartitions = {

			@TopicPartition(topic = "my-replicated-topic", partitions = { "3" } ) })
	public void listen4(String message) {
		System.out.println("Received Messasge in group - group-id3: " + message);
	}
	
	@org.springframework.kafka.annotation.KafkaListener(id = "consumer3", groupId = "group-id", topicPartitions = {

			@TopicPartition(topic = "my-replicated-topic", partitions = { "2" } ) })
	public void listen2(String message) {
		System.out.println("Received Messasge in group - group-id2: " + message);
	}
	
	@org.springframework.kafka.annotation.KafkaListener(id = "consumer4", groupId = "group-id", topicPartitions = {

			@TopicPartition(topic = "my-replicated-topic", partitions = { "4" } ) })
	public void liste31(String message) {
		System.out.println("Received Messasge in group - group-id4: " + message);
	}*/
	
	/*@org.springframework.kafka.annotation.KafkaListener(id = "streamConsumer", groupId = "streamGrp", topics="streamTest")
	public void streamListner(String message) {
		System.out.println("Received Messasge in group - streamGrp: " + message);
	}*/

	/*@org.springframework.kafka.annotation.KafkaListener(id = "consumer2",topics = "my-replicated-topic", groupId = "group-id")
	public void listen1(String message) {
		System.out.println("Received Messasge in group - group-id2: " + message);
	}

	@org.springframework.kafka.annotation.KafkaListener(id = "consumer3",topics = "my-replicated-topic", groupId = "group-id")
	public void listen2(String message) {
		System.out.println("Received Messasge in group - group-id3: " + message);
	}

	@org.springframework.kafka.annotation.KafkaListener(id = "consumer4",topics = "my-replicated-topic", groupId = "group-id")
	public void listen3(String message) {
		System.out.println("Received Messasge in group - group-id4: " + message);
	}

	@org.springframework.kafka.annotation.KafkaListener(id = "consumer5",topics = "my-replicated-topic", groupId = "group-id")
	public void listen4(String message) {
		System.out.println("Received Messasge in group - group-id5: " + message);
	}

	@org.springframework.kafka.annotation.KafkaListener(id = "consumer6",topics = "my-replicated-topic", groupId = "group-id")
	public void listen5(String message) {
		System.out.println("Received Messasge in group - group-id6: " + message);
	}*/
}
