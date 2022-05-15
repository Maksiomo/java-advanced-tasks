package com.maksiomo.event.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.maksiomo.event.model.ClientEvent;
import com.maksiomo.event.model.ClientSpringEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class ClientPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(ClientEvent event) {
        ClientSpringEvent clientSpringEvent = new ClientSpringEvent(this, event);
        publisher.publishEvent(clientSpringEvent);
    }
}