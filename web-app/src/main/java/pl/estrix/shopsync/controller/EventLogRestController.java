package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.messaging.publisher.ProducerCustomerService;
import pl.estrix.shopsync.model.EventLogDto;
import pl.estrix.shopsync.service.EventLogService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/eventlog")
public class EventLogRestController {

    private final EventLogService service;
//    private final ProducerCustomerService serviceQ;

    @PostMapping(path="/list")
    public Page<EventLogDto> list(@RequestBody PagingRequest pagingRequest) {
//        serviceQ.sendCustomer(pagingRequest.getPlatformCode(),pagingRequest.getStart());
        return service.getList(pagingRequest);
    }
}
