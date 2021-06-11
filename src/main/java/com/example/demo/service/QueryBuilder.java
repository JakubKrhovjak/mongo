package com.example.demo.service;

import com.example.demo.entity.table.TableRequest;
import java.io.CharArrayReader;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.CaseUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


/**
 * Created by Jakub krhovják on 5/27/21.
 */
public final class QueryBuilder {

    public static char UNDERSCORE = '_';

    public enum OperatorType {
        CONTAINS,
        EQUALS,
        STARTS_WITH,
        ENDS_WITH;

        public boolean is(String operator) {
            return CaseUtils.toCamelCase(this.name(), false, UNDERSCORE).equals(operator);
        }
    }

    private QueryBuilder() {

    }

    public static Query buildQuery(TableRequest tableRequest) {
        var query = new Query();
        tableRequest.getFilters().forEach(filter -> {
            if (OperatorType.CONTAINS.is(filter.getOperatorValue())) {
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(".*" + filter.getValue() + ".*"));
            }
            if (OperatorType.EQUALS.is(filter.getOperatorValue())) {
                query.addCriteria(Criteria.where(filter.getColumnField()).regex("^" + filter.getValue() + "$"));
            }
            if (OperatorType.STARTS_WITH.is(filter.getOperatorValue())) {
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(".*" + filter.getValue()));
            }
            if (OperatorType.ENDS_WITH.is(filter.getOperatorValue())) {
                query.addCriteria(Criteria.where(filter.getColumnField()).regex(filter.getValue() + ".*"));
            }
        });
        return query; //.with(PageRequest.of(tableRequest.getPage(), tableRequest.getPageSize(), tableRequest.getSort()));

    }

    public static <T> Page<T> buildPage(List<T> rows, Query query, long count) {
        int page = (int) query.getSkip() / query.getLimit();
        return new PageImpl<T>(rows, PageRequest.of(page, query.getLimit()), count);
    }
    //
    //    public <T> Mono<Page<T>> getPage(ReactiveMongoRepository<T, String> repository, Query query) {
    //        return repository.find(query, Ite).count()
    //            .flatMap(count -> {
    //                return repository.find(query, Item.class)
    //                    .buffer(query.getLimit(), (int) query.getSkip() + 1)
    //                    .elementAt(0, new ArrayList<>())
    //                    .map(rows -> QueryBuilder.buildPage(rows, query, count));
    //                //                    .map(rows -> new PageImpl<Item>(rows, PageRequest.of(page, query.getLimit()), count));
    //                //                    .map(rows -> new PageImpl<Item>(rows, pageable, count));
    //            });
    //
    //    }


}
