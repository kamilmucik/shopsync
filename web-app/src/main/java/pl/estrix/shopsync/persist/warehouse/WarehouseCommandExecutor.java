package pl.estrix.shopsync.persist.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.WarehouseMapper;
import pl.estrix.shopsync.model.ShopDto;
import pl.estrix.shopsync.model.WarehouseDto;
import pl.estrix.shopsync.model.WarehouseSearchCriteriaDto;
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao;
import pl.estrix.shopsync.persist.warehouse.repo.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WarehouseCommandExecutor extends BaseCommandExecutor<WarehouseDao, ShopDto> {

    @Autowired
    protected WarehouseRepository repository;

    @Override
    protected Class<ShopDto> getDtoClass() {
        return ShopDto.class;
    }


    private List<WarehouseDto> queryResultList = new ArrayList<>();

    public ListResponseDto<WarehouseDto> find(WarehouseSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<WarehouseDao> result = repository.find(searchCriteria, pagingCriteria);
        queryResultList.clear();
        if (!result.isEmpty()) {
            queryResultList = result
                .stream()
                .map(WarehouseMapper.INSTANCE::map)
                .collect(Collectors.toList());
        }

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public WarehouseDto getById(Long id){
        return WarehouseMapper.INSTANCE.map(repository.getOne(id));
    }

    public WarehouseDto update(WarehouseDto dto) {
        return WarehouseMapper.INSTANCE.map(
                repository.save(WarehouseMapper.INSTANCE.map(dto)
                ));
    }

    public WarehouseDto create(WarehouseDto dto) {
        return WarehouseMapper.INSTANCE.map(
                repository.save(WarehouseMapper.INSTANCE.map(dto)
                ));
    }
}
