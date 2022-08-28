package pl.estrix.shopsync.persist.shop.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.ShopSearchCriteriaDto;
import pl.estrix.shopsync.persist.shop.model.ShopDao;

import java.util.List;

public interface ShopRepositoryCustom {

    List<ShopDao> find(ShopSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(ShopSearchCriteriaDto searchCriteria);
}
