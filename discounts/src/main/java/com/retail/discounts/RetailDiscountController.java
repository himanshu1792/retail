package com.retail.discounts;


import java.util.Date;

import javax.validation.Valid;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@RestController
public class RetailDiscountController {

	@Autowired
	private RetailDiscountService retailDiscountService;
	
	@Autowired
	private JmsTemplate jms;
	
	@Autowired
	 private KafkaTemplate<String, String> kafkaTemplate;

	@RequestMapping(value = "/discount", method = RequestMethod.POST)
	public ResponseBodyEmitter calculateDiscount(@Valid @RequestBody Bill bill) {

		ResponseBodyEmitter emmitter = new ResponseBodyEmitter();
		
		String returnValue = null;
		try {
			//Bill bill = CommonUtils.jsonStringToObject(body, Bill.class);
			int finalBill = retailDiscountService.calculateDiscountForUser(bill);
			//emmitter.send(finalBill);		
			returnValue = "Final bill after discount is " + finalBill;
			emmitter.send(returnValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		emmitter.complete();
		return emmitter;

	}
	
	@RequestMapping(value = "/jms", method = RequestMethod.GET)
	public void jmsTester() {
		
		
		jms.convertAndSend("jms.message.endpoint",  new Message(1001L, "test body", new Date()));
		
		
	}
	
	

	@RequestMapping(value = "/kafka", method = RequestMethod.GET)
	public void kafkaTester() {
		
		
		kafkaTemplate.send(new ProducerRecord<String, String>("tutorialspoint1", "test1", "himanshu saini enclave delhi"));
		//kafkaTemplate.send("tutorialspoint","himanshu saini enclave delhi");
		
	}

	

}
