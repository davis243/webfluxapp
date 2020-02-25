package com.davis.webfluxapp.controller;

import com.davis.webfluxapp.model.Gadget;
import com.davis.webfluxapp.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/gadget")
public class GadgetController {

    @Autowired
    GadgetRepository gadgetRepository;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Gadget> getAll(){
        return  gadgetRepository.findAll().delayElements(Duration.ofMillis(250));
    }

    @GetMapping("/{id}")
    public Mono<Gadget> getById(@PathVariable String id){

        return  gadgetRepository.findById(id);
    }
}
