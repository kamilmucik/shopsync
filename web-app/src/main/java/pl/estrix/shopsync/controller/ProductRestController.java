package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.ProductDto;
import pl.estrix.shopsync.service.ProductService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/product")
public class ProductRestController {

    private final ProductService service;

    @PostMapping(path="/list")
    public Page<ProductDto> list(@RequestBody PagingRequest pagingRequest) {
        return service.getList(pagingRequest);
    }
}
