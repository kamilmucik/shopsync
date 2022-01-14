package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.PlatformDto;
import pl.estrix.shopsync.model.PlatformSearchCriteriaDto;
import pl.estrix.shopsync.persist.platform.executor.PlatformCommandExecutor;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;
import pl.estrix.shopsync.service.PlatformService;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service("platformService")
public class PlatformServiceImpl implements PlatformService {

//    @Autowired
    private final PlatformCommandExecutor executor;

    @Override
    public List<PlatformDto> getAllPlatforms() {
        ListResponseDto<PlatformDto> list = executor.find(
                PlatformSearchCriteriaDto.builder()
                .build(),
                PagingCriteria.builder()
                        .orderColumn("id")
                        .orderDir("DESC")
                        .build());
        return list.getData();
    }

    @Override
    public Page<PlatformDto> getAllPlatforms(PagingRequest pagingRequest) {

        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }
        ListResponseDto<PlatformDto> users = executor.find(
                PlatformSearchCriteriaDto.builder()
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
    public PlatformEntry getById(Long id) {
        return null;
    }

    private Page<PlatformDto> getPage(List<PlatformDto> employees, PagingRequest pagingRequest, Integer total) {
        Page<PlatformDto> page = new Page<>(employees);
        page.setRecordsFiltered(total);
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
}
