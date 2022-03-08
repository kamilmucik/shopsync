package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.model.SettingSearchCriteriaDto;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.setting.SettingCommandExecutor;
import pl.estrix.shopsync.service.SettingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SettingServiceImpl implements SettingService {

    private final SettingCommandExecutor executor;

    @Override
    public Page<SettingDto> getList(PagingRequest pagingRequest) {
        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }

        ListResponseDto<SettingDto> users = executor.find(
                SettingSearchCriteriaDto.builder()
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
    public SettingDto getById(Long id) {
        return executor.getById(id);
    }

    @Override
    public SettingDto save(SettingDto dto) {
        SettingDto temp = executor.getById(dto.getId());
        if (dto.getId() != null){
            temp.setValue(dto.getValue());
            temp = executor.update(temp);
        } else {
            temp = executor.create(dto);
        }
        return temp;
    }

    private Page<SettingDto> getPage(List<SettingDto> list, PagingRequest pagingRequest, Integer total) {
        Page<SettingDto> page = new Page<>(new ArrayList<>());
        page.setData(list);
        page.setRecordsFiltered(total);
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
}
