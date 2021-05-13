package com.example.demo.repository;

import com.example.demo.entity.Item;

import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * Created by Jakub krhovják on 5/13/21.
 */

@Profile("maria")
public interface ItemRdbcRepository extends R2dbcRepository<Item, String> {

}
