package pl.estrix.shopsync.persist.eventlog.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.EventLogSearchCriteriaDto;
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao;

import java.util.List;

public interface EventLogRepositoryCustom {

    List<EventLogDao> find(EventLogSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(EventLogSearchCriteriaDto searchCriteria);
}
