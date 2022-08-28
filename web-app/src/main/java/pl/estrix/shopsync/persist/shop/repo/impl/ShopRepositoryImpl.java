package pl.estrix.shopsync.persist.shop.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.ShopSearchCriteriaDto;
import pl.estrix.shopsync.persist.shop.model.QShopDao;
import pl.estrix.shopsync.persist.shop.model.ShopDao;
import pl.estrix.shopsync.persist.shop.repo.ShopRepositoryCustom;

import java.util.List;

public class ShopRepositoryImpl extends QueryDslRepositorySupportBase implements ShopRepositoryCustom {

    private static final QShopDao shop = new QShopDao("shopDao");

    public ShopRepositoryImpl() {
        super(ShopDao.class);
    }

    @Override
    public List<ShopDao> find(ShopSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<ShopDao> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(ShopSearchCriteriaDto searchCriteria) {
        JPQLQuery<ShopDao> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<ShopDao> fieldPath = Expressions.path(ShopDao.class, QShopDao.shopDao, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<ShopDao> getQueryForFind(ShopSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<ShopDao> query = from(shop);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    shop.name.contains(searchParams.getSearch())
            );
        }

        query.where(builder);
        return query;
    }
}
