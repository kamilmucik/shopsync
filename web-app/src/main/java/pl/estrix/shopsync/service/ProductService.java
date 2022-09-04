package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.ProductDto;

public interface ProductService {

    Page<ProductDto> getList(PagingRequest pagingRequest);

    ProductDto getById(Long id);

    ProductDto save(ProductDto product);
}
