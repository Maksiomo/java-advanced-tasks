package com.maksiomo.event.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
@Getter
@Setter
public class ClientSpringEvent extends ApplicationEvent {
    private ClientEvent event;

    public ClientSpringEvent(Object source, ClientEvent event) {
        super(source);
        this.event = event;
    }

}
