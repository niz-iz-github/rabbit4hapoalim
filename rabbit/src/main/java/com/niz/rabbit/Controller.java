package com.niz.rabbit;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rabbit")
public class Controller {

	@Autowired
	Receiver receiver;
	
	@Autowired
	RabbitTemplate rabbitTemplate;

    @PostMapping("/account")
    public String showAccount(@RequestBody Account account) {
    	String res = "No message found on Queue"; 
    	System.out.println("Sending message...");
    	receiver.setLastMsg("Time out while waitting to message...");
    	receiver.setLatch(new CountDownLatch(1));
    	rabbitTemplate.convertAndSend(
    			RabbitApplication.topicExchangeName,
    			"hapoalim.nizan",
    			account.toString()
    	);
    	try {
    		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    		res = receiver.getLastMsg();
    	}
    	catch(InterruptedException  e)
    	{
    		return "Interrupted...";
    	}
        return res;
    }

  
}
