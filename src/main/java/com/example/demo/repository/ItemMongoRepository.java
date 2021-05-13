package com.example.demo.repository;

import com.example.demo.entity.Item;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

/**
 * Created by Jakub krhovják on 5/13/21.
 */
@Profile("mongo")
public interface ItemMongoRepository extends ReactiveMongoRepository<Item, String> {

    @Query(value ="{ 'name' : ?0 }", fields="{ 'name' : 1}")
    Flux<Item> byName(String name);
}
