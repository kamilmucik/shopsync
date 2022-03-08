package pl.estrix.shopsync.persist.user.repo.impl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.UserSearchCriteriaDto;
import pl.estrix.shopsync.persist.user.model.QUser;
import pl.estrix.shopsync.persist.user.model.User;
import pl.estrix.shopsync.persist.user.repo.UserRepositoryCustom;

import java.util.List;

public class UserRepositoryImpl extends QueryDslRepositorySupportBase implements UserRepositoryCustom {

    private static final QUser user = new QUser("user");

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public List<User> find(UserSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<User> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(UserSearchCriteriaDto searchCriteria) {
        JPQLQuery<User> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<User> fieldPath = Expressions.path(User.class, QUser.user, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<User> getQueryForFind(UserSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<User> query = from(user);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    user.email.contains(searchParams.getSearch())
                    .or(user.firstName.contains(searchParams.getSearch()))
                    .or(user.lastName.contains(searchParams.getSearch()))
            );
        }

        query.where(builder);
        return query;
    }
}
