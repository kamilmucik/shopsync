package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.ShopDto;
import pl.estrix.shopsync.model.ShopSearchCriteriaDto;
import pl.estrix.shopsync.persist.shop.ShopCommandExecutor;
import pl.estrix.shopsync.service.ShopService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopCommandExecutor executor;

    @Override
    public Page<ShopDto> getList(PagingRequest pagingRequest) {
        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }

        ListResponseDto<ShopDto> users = executor.find(
                ShopSearchCriteriaDto.builder()
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
    public ShopDto getById(Long id) {
        return executor.getById(id);
    }

    @Override
    public ShopDto save(ShopDto dto) {
        ShopDto temp;
        if (dto.getId() != null && dto.getId() > 0) {
            temp = executor.getById(dto.getId());
        } else {
            temp = new ShopDto();
        }
        temp.setName(dto.getName());
        temp.setLastUpdate(dto.getName());
        temp.setUrl(dto.getName());
        temp.setApiUrl(dto.getName());
        if (dto.getId() != null){
            temp = executor.update(temp);
        } else {
            temp = executor.create(temp);
        }
        return temp;
    }

    private Page<ShopDto> getPage(List<ShopDto> list, PagingRequest pagingRequest, Integer total) {
        Page<ShopDto> page = new Page<>(new ArrayList<>());
        page.setData(list);
        page.setRecordsFiltered(total);
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
}
