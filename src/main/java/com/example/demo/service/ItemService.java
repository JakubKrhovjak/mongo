package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    private ItemRepository itemRepository;

    public Mono<Page<Item>> getPage(Pageable pageable) {
        return this.itemRepository.count()
                .flatMap(userCount -> {
                    return this.itemRepository.findAll(pageable.getSort())
                            .buffer(pageable.getPageSize(), (pageable.getPageNumber() + 1))
                            .elementAt(pageable.getPageNumber(), new ArrayList<>())
                            .map(users -> new PageImpl<Item>(users, pageable, userCount));
                });
    }
}


