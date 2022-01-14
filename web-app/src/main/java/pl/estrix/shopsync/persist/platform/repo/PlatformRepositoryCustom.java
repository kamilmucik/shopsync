package pl.estrix.shopsync.persist.platform.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.PlatformSearchCriteriaDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;

import java.util.List;

public interface PlatformRepositoryCustom {

    List<PlatformEntry> find(PlatformSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(PlatformSearchCriteriaDto searchCriteria);
}
