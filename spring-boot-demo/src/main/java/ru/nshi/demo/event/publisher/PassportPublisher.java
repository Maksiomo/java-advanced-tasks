package ru.nshi.demo.event.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.nshi.demo.event.model.PassportEvent;
import ru.nshi.demo.event.model.PassportSpringEvent;

/**
 * @author rassafel
 */
@RequiredArgsConstructor
@Slf4j
@Component
public class PassportPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(PassportEvent event) {
        PassportSpringEvent passportSpringEvent = new PassportSpringEvent(this, event);
        publisher.publishEvent(passportSpringEvent);
    }
}
