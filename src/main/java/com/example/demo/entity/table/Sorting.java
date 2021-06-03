package com.example.demo.entity.table;

import java.util.Optional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;


/**
 * Created by Jakub krhovják on 6/3/21.
 */
@Data
@NoArgsConstructor
public class Sorting {

    private String field;
    private Optional<String> direction = Optional.empty();

}
