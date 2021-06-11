package com.example.demo.Item;

import com.example.demo.Item.domain.Item;

import com.example.demo.service.PageSupport;
import com.example.demo.service.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Created by Jakub krhovják on 5/16/21.
 */
@Service
@AllArgsConstructor
public class ItemService {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    private final ItemRepository itemRepository;

    public Mono<Page<Item>> getPage(Query query, Pageable pageable) {

        return reactiveMongoTemplate.count(query, Item.class)
            .flatMap(count -> {
                return reactiveMongoTemplate.find(query.with(pageable), Item.class)
                    .buffer(pageable.getPageSize(), 1)
                    .map(v -> {
                        return v;
                    })
                    .elementAt(0 , new ArrayList<>())
                    .map(rows -> {

                        return new PageImpl<Item>(rows, pageable, count);
                    });

            });
    }

//    public Mono<?> getPageA(Query query, Pageable pageable) {
//        return reactiveMongoTemplate.count(query, Item.class)
//            .flatMap(count -> {
//                return reactiveMongoTemplate.find(query, Item.class)
//                    .buffer(pageable.getPageSize(), pageable.getPageNumber() + 1)
////                    .elementAt(pageable.getPageNumber(), new ArrayList<>())
//                    .map(rows -> {
//
//                        return new PageImpl<Item>(rows, pageable, count);
//                    });
//                //                    .map(rows -> QueryBuilder.buildPage(rows, query, count));
//                //                    .map(rows -> new PageImpl<Item>(rows, PageRequest.of(page, query.getLimit()), count));
//                //                    .map(rows -> new PageImpl<Item>(rows, pageable, count));
//            });
//    }

//        PageableExecutionUtils.getPage()
//        reactiveMongoTemplate.query(Item.class).matching(criteria)
//            .count().flatMap(count -> {
//            var query = new Query(Criteria.where("name").is("name2"));
//            return reactiveMongoTemplate.find(query, Item.class);
//        }).


//
////        Example<Item> of = Example.of(new Item().setName("name2"), matching);
//        var query = new Query(criteria1);
//        query.getQ

//        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("name");


//        return this.itemRepository.count(Query.of(query).limit(-1).skip(-1), XXX.class))
//                .flatMap(userCount -> {
//                    return this.itemRepository.findAllBy(criteria, pageable)
//                            .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
//                            .elementAt(pageable.getPageNumber(), new ArrayList<>())
//                            .map(rows -> new PageImpl<Item>(rows, pageable, userCount));
//                });
//    }

//    public Mono<Page<Item>> getPage(Query query) {
//        query.get
//        return reactiveMongoTemplate.find(query, Item.class).count()
//            .flatMap(count -> {
//                return reactiveMongoTemplate.find(query, Item.class)
//                    .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
//                    .elementAt(pageable.getPageNumber(), new ArrayList<>())
//                    .map(rows -> new PageImpl<Item>(rows, pageable, count));
//            });
//
//    }





    public Mono<Page<Item>> f(Pageable pageable) {
        return  PageSupport.getPage(itemRepository, pageable);

    }
}


