package com.activemq.listener;

import com.activemq.config.JmsConfig;
import com.activemq.model.HelloWorldMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageListener {
    
    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(HelloWorldMessage helloWorldMessage) {
        System.out.println("Message Received: " + helloWorldMessage);
    }
}
