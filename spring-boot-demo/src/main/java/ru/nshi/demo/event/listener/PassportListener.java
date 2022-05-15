package ru.nshi.demo.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.nshi.demo.event.model.PassportSpringEvent;

/**
 * @author rassafel
 */
@Slf4j
@Component
public class PassportListener implements ApplicationListener<PassportSpringEvent> {
    @Override
    public void onApplicationEvent(PassportSpringEvent event) {
        log.info("{}", event);
    }
}
