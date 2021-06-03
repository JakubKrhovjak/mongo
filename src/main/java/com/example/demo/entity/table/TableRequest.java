package com.example.demo.entity.table;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


/**
 * Created by Jakub krhovják on 5/19/21.
 */
@Data
public class TableRequest {

    private List<Filter> filters = List.of();

    private int page;

    private int pageSize;

    private Sorting sort;

    public Sort getSort() {
        return sort.getDirection()
            .map(direction -> Sort.by(direction, sort.getField()))
            .orElse(Sort.unsorted());

    }
}
