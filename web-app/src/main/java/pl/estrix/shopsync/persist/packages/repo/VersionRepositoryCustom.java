package pl.estrix.shopsync.persist.packages.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.VersionSearchCriteriaDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

import java.util.List;

public interface VersionRepositoryCustom {

    List<VersionEntry> find(VersionSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(VersionSearchCriteriaDto searchCriteria);
}
