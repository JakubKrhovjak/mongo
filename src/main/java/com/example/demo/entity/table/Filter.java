package com.example.demo.entity.table;

import lombok.Data;


/**
 * Created by Jakub krhovják on 5/27/21.
 */
@Data
public class Filter {

    private String columnField;
    private String operatorValue;
    private String value;
}
