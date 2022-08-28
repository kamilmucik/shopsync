package pl.estrix.shopsync.persist.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.ShopMapper;
import pl.estrix.shopsync.model.ShopDto;
import pl.estrix.shopsync.model.ShopSearchCriteriaDto;
import pl.estrix.shopsync.persist.shop.model.ShopDao;
import pl.estrix.shopsync.persist.shop.repo.ShopRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopCommandExecutor extends BaseCommandExecutor<ShopDao, ShopDto> {

    @Autowired
    protected ShopRepository repository;

    @Override
    protected Class<ShopDto> getDtoClass() {
        return ShopDto.class;
    }


    private List<ShopDto> queryResultList = new ArrayList<>();

    public ListResponseDto<ShopDto> find(ShopSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<ShopDao> result = repository.find(searchCriteria, pagingCriteria);
        queryResultList.clear();
        if (!result.isEmpty()) {
            queryResultList = result
                .stream()
                .map(ShopMapper.INSTANCE::map)
                .collect(Collectors.toList());
        }

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public ShopDto getById(Long id){
        return ShopMapper.INSTANCE.map(repository.getOne(id));
    }

    public ShopDto update(ShopDto dto) {
        return ShopMapper.INSTANCE.map(
                repository.save(ShopMapper.INSTANCE.map(dto)
                ));
    }

    public ShopDto create(ShopDto dto) {
        return ShopMapper.INSTANCE.map(
                repository.save(ShopMapper.INSTANCE.map(dto)
                ));
    }
}
