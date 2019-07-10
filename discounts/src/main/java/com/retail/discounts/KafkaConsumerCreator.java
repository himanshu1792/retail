package com.retail.discounts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerCreator implements Runnable {
	
	private static  KafkaConsumer<String, String> kafkaConsumer =  createCons();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		 /*
	     * We will start an infinite while loop, inside which we'll be listening to
	     * new messages in each topic that we've subscribed to.
	     */
	    //while(true) {

		//KafkaConsumer<String, String> kafkaConsumer =  createCons();
	        ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
	        

	        for (ConsumerRecord<String, String> record : records) {

	            /*
	            Whenever there's a new message in the Kafka topic, we'll get the message in this loop, as the record object.
	             */

	            /*
	            Getting the message as a string from the record object.
	             */
	            String message = record.value();

	            System.out.println(message+"message recieved");
	            /*
	            Logging the received message to the console.
	             */
	            

	            /*
	            If you remember, we sent 10 messages to this topic as plain strings. 10 other messages were serialized JSON objects. Now we'll deserialize them here. But since we can't make out which message is a serialized JSON object and which isn't, we'll try to deserialize all of them. So, obviously, we'll get an exception for the first 10 messages we receive. We'll just log the errors and not worry about them.
	             */
	           

	            /*
	            Once we finish processing a Kafka message, we have to commit the offset so that we don't end up consuming the same message endlessly. By default, the consumer object takes care of this. But to demonstrate how it can be done, we have turned this default behaviour off, instead, we're going to manually commit the offsets.
	            The code for this is below. It's pretty much self explanatory.
	             */
	            
	                Map<TopicPartition, OffsetAndMetadata> commitMessage = new HashMap<>();

	                commitMessage.put(new TopicPartition(record.topic(), record.partition()),
	                        new OffsetAndMetadata(record.offset() + 1));

	                kafkaConsumer.commitSync(commitMessage);

	                
	                
	        }
	        //kafkaConsumer.unsubscribe();
	    //}
	}
	
	
	public static KafkaConsumer<String, String> createCons() {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "streamTestGrp1");
		props.put("enable.auto.commit", "false");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		@SuppressWarnings("resource")
		KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
		kafkaConsumer.subscribe(Arrays.asList("streamTest"));
		return kafkaConsumer;
	}

}
