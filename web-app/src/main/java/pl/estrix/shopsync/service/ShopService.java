package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.ShopDto;

public interface ShopService {

    Page<ShopDto> getList(PagingRequest pagingRequest);

    ShopDto getById(Long id);

    ShopDto save(ShopDto product);
}
