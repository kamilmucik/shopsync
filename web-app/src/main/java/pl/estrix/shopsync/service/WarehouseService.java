package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.WarehouseDto;

public interface WarehouseService {

    Page<WarehouseDto> getList(PagingRequest pagingRequest);

    WarehouseDto getById(Long id);

    WarehouseDto save(WarehouseDto product);
}
