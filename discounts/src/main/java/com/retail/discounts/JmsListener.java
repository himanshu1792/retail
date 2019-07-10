package com.retail.discounts;


import org.springframework.stereotype.Component;

@Component
public class JmsListener {
	
	@org.springframework.jms.annotation.JmsListener(destination = "jms.message.endpoint", containerFactory = "myFactory")
    public void receiveMessage(Message msg)
    {
        System.out.println("Received " + msg );
    }
	
	@org.springframework.jms.annotation.JmsListener(destination = "jms.message.endpoint", containerFactory = "myFactory")
    public void receiveMessage1(Message msg)
    {
        System.out.println("Received 1 " + msg );
    }

}
