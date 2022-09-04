package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.EventLogDto;
import pl.estrix.shopsync.model.EventLogSearchCriteriaDto;
import pl.estrix.shopsync.persist.eventlog.EventLogCommandExecutor;
import pl.estrix.shopsync.service.EventLogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EventLogServiceImpl implements EventLogService {

    private final EventLogCommandExecutor executor;

    @Override
    public Page<EventLogDto> getList(PagingRequest pagingRequest) {
        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }

        ListResponseDto<EventLogDto> users = executor.find(
                EventLogSearchCriteriaDto.builder()
                        .search(pagingRequest.getSearch().getValue())
                        .build(),
                PagingCriteria.builder()
                        .start(pagingRequest.getStart())
                        .limit(pagingRequest.getLength())
                        .orderColumn(orderColumn)
                        .orderDir(orderDir)
                        .build());
        return getPage(users.getData(), pagingRequest,users.getTotalCount());
    }

    @Override
    public EventLogDto getById(Long id) {
        return executor.getById(id);
    }


    @Override
    public EventLogDto save(EventLogDto dto) {
        EventLogDto temp;
        if (dto.getId() != null) {
            temp = executor.getById(dto.getId());
        } else {
            temp = new EventLogDto();
        }
        if (dto.getId() != null){
            temp = executor.update(temp);
        } else {
            temp = executor.create(temp);
        }
        return temp;
    }

    private Page<EventLogDto> getPage(List<EventLogDto> list, PagingRequest pagingRequest, Integer total) {
        Page<EventLogDto> page = new Page<>(new ArrayList<>());
        page.setData(list);
        page.setRecordsFiltered(total);
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
}
