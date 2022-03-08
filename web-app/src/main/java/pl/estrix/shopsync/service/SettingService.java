package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.SettingDto;

public interface SettingService {

    Page<SettingDto> getList(PagingRequest pagingRequest);

    SettingDto getById(Long id);

    SettingDto save(SettingDto product);
}
