package com.example.demo.Event;

import com.example.demo.Event.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


/**
 * Created by Jakub krhovják on 6/24/21.
 */
@RestController
public class EventController {

    @Autowired
    private Flux<Event> flux;

    @GetMapping(value = "/event", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> getJoke(){
        return flux;
    }

}
