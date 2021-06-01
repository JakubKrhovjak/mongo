package com.example.demo.entity.table;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


/**
 * Created by Jakub krhovják on 5/19/21.
 */
@Data
public class TableRequest {

    private List<Filter> items = List.of();

    private int page;

    private int pageSize;
}
