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
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(".*" + filter.getValue() +  ".*"));
            }
            if(OperatorType.EQUALS.is(filter.getOperatorValue())){
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(filter.getValue()));
            }
            if(OperatorType.STARTS_WITH.is(filter.getOperatorValue())){
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(".*" + filter.getValue()));
            }
            if(OperatorType.END_WITH.is(filter.getOperatorValue())){
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(filter.getValue()+  ".*"));
            }
        });
        return query.with(PageRequest.of(tableRequest.getPage(), tableRequest.getPageSize()));

    }


}
