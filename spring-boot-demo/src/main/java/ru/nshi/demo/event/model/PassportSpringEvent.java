package ru.nshi.demo.event.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

/**
 * @author rassafel
 */
@Slf4j
@Getter
@Setter
public class PassportSpringEvent extends ApplicationEvent {
    private PassportEvent event;

    public PassportSpringEvent(Object source, PassportEvent event) {
        super(source);
        this.event = event;
    }
}
