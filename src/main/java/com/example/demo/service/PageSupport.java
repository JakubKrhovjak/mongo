package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;


/**
 * Created by Jakub krhovják on 5/19/21.
 */
public class PageSupport {

    public static <T, ID> Mono<Page<T>> getPage(ReactiveMongoRepository<T, ID> repository, Pageable pageable) {
        return repository.count()
            .flatMap(count ->
                 repository.findAll( pageable.getSort())
                    .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
                    .elementAt(pageable.getPageNumber(), new ArrayList<>())
                    .map(rows -> new PageImpl<T>(rows, pageable, count))
            );
    }
}
