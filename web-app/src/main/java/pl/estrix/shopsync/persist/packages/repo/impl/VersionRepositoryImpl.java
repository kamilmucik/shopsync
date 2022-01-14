package pl.estrix.shopsync.persist.packages.repo.impl;

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
import pl.estrix.shopsync.model.VersionSearchCriteriaDto;
import pl.estrix.shopsync.persist.packages.model.QVersionEntry;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.persist.packages.repo.VersionRepositoryCustom;

import java.util.List;

@Component
public class VersionRepositoryImpl extends QueryDslRepositorySupportBase implements VersionRepositoryCustom {

    private static final QVersionEntry versionEntry = new QVersionEntry("versionEntry");

    public VersionRepositoryImpl() {
        super(VersionEntry.class);
    }

    @Override
    public List<VersionEntry> find(VersionSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<Object> fieldPath = Expressions.path(Object.class, QVersionEntry.versionEntry, fieldName);
        return new OrderSpecifier(order, fieldPath);
    }

    @Override
    public long findCount(VersionSearchCriteriaDto searchCriteria) {
        JPQLQuery query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    private JPQLQuery getQueryForFind(VersionSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery query = from(versionEntry);

        if (StringUtils.isNotEmpty(searchParams.getPlatform())){
            query.where(
                    versionEntry.platform.eq(searchParams.getPlatform())
            );
        }

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    versionEntry.number.contains(searchParams.getSearch())
                    .or(versionEntry.description.contains(searchParams.getSearch()))
                    .or(versionEntry.installer.contains(searchParams.getSearch()))
                    .or(versionEntry.enviroment.contains(searchParams.getSearch()))
            );
        }

        query.where(builder);
        return query;
    }
}
