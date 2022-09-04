package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.EventLogDto;

public interface EventLogService {

    Page<EventLogDto> getList(PagingRequest pagingRequest);

    EventLogDto getById(Long id);

    EventLogDto save(EventLogDto dto);
}
