package pl.estrix.shopsync.persist.warehouse.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.WarehouseSearchCriteriaDto;
import pl.estrix.shopsync.persist.warehouse.model.QWarehouseDao;
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao;
import pl.estrix.shopsync.persist.warehouse.repo.WarehouseRepositoryCustom;

import java.util.List;

public class WarehouseRepositoryImpl extends QueryDslRepositorySupportBase implements WarehouseRepositoryCustom {

    private static final QWarehouseDao warehouse = new QWarehouseDao("warehouseDao");

    public WarehouseRepositoryImpl() {
        super(WarehouseDao.class);
    }

    @Override
    public List<WarehouseDao> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<WarehouseDao> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(WarehouseSearchCriteriaDto searchCriteria) {
        JPQLQuery<WarehouseDao> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<WarehouseDao> fieldPath = Expressions.path(WarehouseDao.class, QWarehouseDao.warehouseDao, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<WarehouseDao> getQueryForFind(WarehouseSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<WarehouseDao> query = from(warehouse);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    warehouse.name.contains(searchParams.getSearch())
            );
        }

        query.where(builder);
        return query;
    }
}
