package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String> {

}
