package com.example.demo;

import com.example.demo.entity.Item;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    @Query(value ="{ 'name' : ?0 }", fields="{ 'name' : 1}")
    List<Item> byName(String name);
}
