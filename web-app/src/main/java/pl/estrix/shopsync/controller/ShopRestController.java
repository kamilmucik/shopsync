package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.ShopDto;
import pl.estrix.shopsync.service.ShopService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/shop")
public class ShopRestController {

    private final ShopService service;

    @PostMapping(path="/list")
    public Page<ShopDto> list(@RequestBody PagingRequest pagingRequest) {
        return service.getList(pagingRequest);
    }
}
