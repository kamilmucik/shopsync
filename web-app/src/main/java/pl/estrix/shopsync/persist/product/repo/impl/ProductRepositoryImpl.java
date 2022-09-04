package pl.estrix.shopsync.persist.product.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.ProductSearchCriteriaDto;
import pl.estrix.shopsync.persist.product.model.ProductDao;
import pl.estrix.shopsync.persist.product.model.QProductDao;
import pl.estrix.shopsync.persist.product.repo.ProductRepositoryCustom;

import java.util.List;

public class ProductRepositoryImpl extends QueryDslRepositorySupportBase implements ProductRepositoryCustom {

    private static final QProductDao product = new QProductDao("productDao");

    public ProductRepositoryImpl() {
        super(ProductDao.class);
    }

    @Override
    public List<ProductDao> find(ProductSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<ProductDao> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(ProductSearchCriteriaDto searchCriteria) {
        JPQLQuery<ProductDao> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<ProductDao> fieldPath = Expressions.path(ProductDao.class, QProductDao.productDao, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<ProductDao> getQueryForFind(ProductSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<ProductDao> query = from(product);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    product.name.contains(searchParams.getSearch())
            );
        }

        query.where(builder);
        return query;
    }
}
