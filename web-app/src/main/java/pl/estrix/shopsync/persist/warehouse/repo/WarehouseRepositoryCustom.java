package pl.estrix.shopsync.persist.warehouse.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.WarehouseSearchCriteriaDto;
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao;

import java.util.List;

public interface WarehouseRepositoryCustom {

    List<WarehouseDao> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(WarehouseSearchCriteriaDto searchCriteria);
}
