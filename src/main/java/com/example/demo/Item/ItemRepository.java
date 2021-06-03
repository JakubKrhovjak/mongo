package com.example.demo.Item;

import com.example.demo.Item.domain.Item;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import org.springframework.data.repository.Repository;
import reactor.core.publisher.Flux;


/**
 * Created by Jakub krhovják on 5/2/21.
 */
public interface ItemRepository extends ReactiveMongoRepository<Item, String>, Repository<Item, String> {

    Flux<Item> findAllBy(Criteria criteria, Pageable pageable);

}

