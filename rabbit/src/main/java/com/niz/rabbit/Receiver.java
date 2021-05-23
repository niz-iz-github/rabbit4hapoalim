package com.niz.rabbit;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private CountDownLatch latch = null;
  private String lastMsg;

  public void receiveMessage(String message) {
    System.out.println("Received by the reciver <" + message + ">");
    lastMsg = message;
    latch.countDown();
  }

  public CountDownLatch getLatch() {
    return latch;
  }

  public void setLatch(CountDownLatch newLatch) {
	    latch = newLatch;
	  }
  
public String getLastMsg() {
	return lastMsg;
}

public void setLastMsg(String str) {
	lastMsg = str;
}


}
