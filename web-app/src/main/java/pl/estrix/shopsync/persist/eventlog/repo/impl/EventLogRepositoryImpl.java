package pl.estrix.shopsync.persist.eventlog.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.EventLogSearchCriteriaDto;
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao;
import pl.estrix.shopsync.persist.eventlog.model.QEventLogDao;
import pl.estrix.shopsync.persist.eventlog.repo.EventLogRepositoryCustom;

import java.util.List;

public class EventLogRepositoryImpl extends QueryDslRepositorySupportBase implements EventLogRepositoryCustom {

    private static final QEventLogDao eventLog = new QEventLogDao("eventLogDao");

    public EventLogRepositoryImpl() {
        super(EventLogDao.class);
    }

    @Override
    public List<EventLogDao> find(EventLogSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<EventLogDao> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(EventLogSearchCriteriaDto searchCriteria) {
        JPQLQuery<EventLogDao> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<EventLogDao> fieldPath = Expressions.path(EventLogDao.class, QEventLogDao.eventLogDao, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<EventLogDao> getQueryForFind(EventLogSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<EventLogDao> query = from(eventLog);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    eventLog.log.contains(searchParams.getSearch())
            );
        }

        query.where(builder);
        return query;
    }
}
