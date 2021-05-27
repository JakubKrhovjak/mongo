package com.example.demo.entity.table;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import lombok.Data;


/**
 * Created by Jakub krhovják on 5/19/21.
 */
@Data
public class TableRequest {

    private List<Filter> items;

    private int skip = 0;

    private int limit = 30;


}
