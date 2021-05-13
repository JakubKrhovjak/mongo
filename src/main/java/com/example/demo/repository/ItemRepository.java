package com.example.demo.repository;

import com.example.demo.entity.Item;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, String>, ReactiveSortingRepository<Item, String> {

}
