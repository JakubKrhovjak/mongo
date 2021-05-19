package com.example.demo.repository;

import com.example.demo.entity.Item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.stereotype.Repository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Jakub krhovják on 5/2/21.
 */
public interface ItemRepository extends ReactiveMongoRepository<Item, String>{

}

