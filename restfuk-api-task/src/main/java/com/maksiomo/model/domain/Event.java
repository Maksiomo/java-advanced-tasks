package com.maksiomo.model.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event_data")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "id_client", length = 8, nullable = false)
    private String id_client;
    @Column(name = "event_type", length = 8, nullable = false)
    private String event_type;
    @Column(name = "event_time", nullable = false)
    private LocalDateTime event_time;

    public Event(String idClient, String clientEvent, LocalDateTime eventTime) {
        this.id_client = idClient;
        this.event_type = clientEvent;
        this.event_time = eventTime;
    }
}
