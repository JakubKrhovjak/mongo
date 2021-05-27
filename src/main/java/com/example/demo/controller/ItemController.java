package com.example.demo.controller;

import com.example.demo.entity.table.TableRequest;
import com.example.demo.repository.ItemRepository;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/mongo")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public Mono<Page<Item>> getItems(@RequestBody(required = false) TableRequest tableRequest) {
        PageRequest of = PageRequest.of(0, 1);
        return itemService.getPage(of,  tableRequest);
    }

//    @GetMapping(value = "/{itemId}")
//    public Optional<Item> getItem(@PathVariable String itemId) {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//            .withIgnorePaths("lastname")
//            .withIncludeNullValues()
//            .withStringMatcherEnding();
//        return itemRepository.findOne(itemId);
//    }

//    @GetMapping(value = "/exact")
//    public Flux<Item> getItem() {
//        ExampleMatcher matcher = ExampleMatcher.matching()
//            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact());
//
//        return itemRepository.findAll(Example.of(new Item().setName("name"), matcher));
//    }

//    @PostMapping(value = "/item")
//    public void postItem(@RequestBody Item item) {
//        itemRepository.save(item);
//    }
//
//    @GetMapping("/name")
//    public Flux<Item> byName() {
//     return itemRepository.byName("name");
//    }
}
