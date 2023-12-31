package com.hrm.cloud.bravo.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessagePublisherImpl implements MessagePublisher{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void postMessage(Object message) {
        log.info("Sending message: {}", message);
        rabbitTemplate.convertAndSend("my-exchange", "my.routing.key.1", message);
    }
}
