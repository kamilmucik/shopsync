package pl.estrix.shopsync.persist.platform.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.PlatformSearchCriteriaDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;
import pl.estrix.shopsync.persist.platform.model.QPlatformEntry;
import pl.estrix.shopsync.persist.platform.repo.PlatformRepositoryCustom;

import java.util.List;

@Component
public class PlatformRepositoryImpl extends QueryDslRepositorySupportBase implements PlatformRepositoryCustom {

    private static final QPlatformEntry platformEntry = new QPlatformEntry("platformEntry");

    public PlatformRepositoryImpl() {
        super(PlatformEntry.class);
    }

    @Override
    public List<PlatformEntry> find(PlatformSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(PlatformSearchCriteriaDto searchCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<Object> fieldPath = Expressions.path(Object.class, QPlatformEntry.platformEntry, fieldName);
        return new OrderSpecifier(order, fieldPath);
    }

    private JPQLQuery getQueryForFind(PlatformSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery query = from(platformEntry);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    platformEntry.name.contains(searchParams.getSearch())
                    .or(platformEntry.code.contains(searchParams.getSearch()))
            );
        }

        query.where(builder);
        return query;
    }
}
