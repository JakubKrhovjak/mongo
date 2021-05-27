package com.example.demo.service;

import com.example.demo.entity.table.TableRequest;
import java.util.Locale;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * Created by Jakub krhovják on 5/27/21.
 */
public final class QueryBuilder {

    public enum OperatorType {
        CONTAINS,
        EQUALS,
        STARTS_WITH,
        END_WITH;

        public boolean is(String operator) {
            return  this.name().toLowerCase(Locale.ROOT).equals(operator);
        }
    }

    private QueryBuilder() {

    }

    public static Query buildQuery(TableRequest tableRequest) {
//        var query = new Query(Criteria.where("name").regex(".*name.*")).with(pageable);
        var query = new Query();
        tableRequest.getItems().forEach(filter -> {
            if(OperatorType.CONTAINS.is(filter.getOperatorValue())){
                query.addCriteria(Criteria.where("name").regex(".*name.*")).limit(tableRequest.getLimit()).skip(tableRequest.getSkip());

            }
        });
        return query;

    }


}
