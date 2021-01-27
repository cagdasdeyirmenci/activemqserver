package com.activemq.sender;

import com.activemq.config.JmsConfig;
import com.activemq.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {

        final HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();
        
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
    }
    
 
}
