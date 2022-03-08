package pl.estrix.shopsync.persist.setting.repo.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang.StringUtils;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.entity.QueryDslRepositorySupportBase;
import pl.estrix.shopsync.model.SettingSearchCriteriaDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;
import pl.estrix.shopsync.persist.setting.model.QAppSetting;
import pl.estrix.shopsync.persist.setting.repo.SettingRepositoryCustom;

import java.util.List;

public class SettingRepositoryImpl extends QueryDslRepositorySupportBase implements SettingRepositoryCustom {

    private static final QAppSetting appSetting = new QAppSetting("appSetting");

    public SettingRepositoryImpl() {
        super(AppSetting.class);
    }

    @Override
    public List<AppSetting> find(SettingSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        JPQLQuery<AppSetting> query = getQueryForFind(searchCriteria);
        query.orderBy(getSortedColumn(Order.valueOf(pagingCriteria.getOrderDir()),pagingCriteria.getOrderColumn()));
        addPagingCriteriaToQuery(query, pagingCriteria);
        return query.fetch();
    }

    @Override
    public long findCount(SettingSearchCriteriaDto searchCriteria) {
        JPQLQuery<AppSetting> query = getQueryForFind(searchCriteria);
        return query.fetchCount();
    }

    /**
     * fieldName - name of field from Person entity
     */
    private OrderSpecifier<?> getSortedColumn(Order order, String fieldName){
        Path<AppSetting> fieldPath = Expressions.path(AppSetting.class, QAppSetting.appSetting, fieldName);
        return new OrderSpecifier<>(order, fieldPath);
    }

    private JPQLQuery<AppSetting> getQueryForFind(SettingSearchCriteriaDto searchParams) {
        BooleanBuilder builder = new BooleanBuilder();

        JPQLQuery<AppSetting> query = from(appSetting);

        if (StringUtils.isNotEmpty(searchParams.getSearch())){
            query.where(
                    appSetting.name.contains(searchParams.getSearch())
                            .or(appSetting.code.contains(searchParams.getSearch()))
                            .or(appSetting.type.contains(searchParams.getSearch()))
                            .or(appSetting.value.contains(searchParams.getSearch()))
            );
        }

        query.where(builder);
        return query;
    }
}
