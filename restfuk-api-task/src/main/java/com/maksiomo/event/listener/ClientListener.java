package com.maksiomo.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.maksiomo.event.model.ClientSpringEvent;

@Slf4j
@Component
public class ClientListener implements ApplicationListener<ClientSpringEvent> {
    @Override
    public void onApplicationEvent(ClientSpringEvent event) {
        log.info("{ }", event);
    }
}
