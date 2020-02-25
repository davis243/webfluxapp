package com.davis.webfluxapp.repository;

import com.davis.webfluxapp.model.Gadget;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetRepository extends ReactiveMongoRepository<Gadget,String> {
}
