package com.example.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by Jakub krhovják on 5/2/21.
 */
@Data
@Accessors(chain = true)
@Document
public class Item {

    @Id
    private String id;

    private String name;

    private String description;
}
