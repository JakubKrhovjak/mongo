package com.example.demo;

import com.example.demo.entity.Item;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String> {

    @Query(value ="{ 'name' : ?0 }", fields="{ 'name' : 1}")
    Flux<Item> byName(String name);
}
