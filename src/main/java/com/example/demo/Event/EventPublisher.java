package com.example.demo.Event;

import com.example.demo.Event.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Sinks;


/**
 * Created by Jakub krhovják on 6/24/21.
 */

@Service
public class EventPublisher {

    @Autowired
    private WebClient webClient;

    @Autowired
    private Sinks.Many<Event> sink;


    @Scheduled(fixedRate = 3000)
    public void publish(){
        sink.tryEmitNext(new Event("test", "test"));
    }
}
