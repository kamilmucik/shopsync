package pl.estrix.shopsync.persist.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.ProductMapper;
import pl.estrix.shopsync.model.ProductDto;
import pl.estrix.shopsync.model.ProductSearchCriteriaDto;
import pl.estrix.shopsync.persist.product.model.ProductDao;
import pl.estrix.shopsync.persist.product.repo.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCommandExecutor extends BaseCommandExecutor<ProductDao, ProductDto> {

    @Autowired
    protected ProductRepository repository;

    @Override
    protected Class<ProductDto> getDtoClass() {
        return ProductDto.class;
    }


    private List<ProductDto> queryResultList = new ArrayList<>();

    public ListResponseDto<ProductDto> find(ProductSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<ProductDao> result = repository.find(searchCriteria, pagingCriteria);
        queryResultList.clear();
        if (!result.isEmpty()) {
            queryResultList = result
                .stream()
                .map(ProductMapper.INSTANCE::map)
                .collect(Collectors.toList());
        }

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public ProductDto getById(Long id){
        return ProductMapper.INSTANCE.map(repository.getOne(id));
    }

    public ProductDto update(ProductDto dto) {
        return ProductMapper.INSTANCE.map(
                repository.save(ProductMapper.INSTANCE.map(dto)
                ));
    }

    public ProductDto create(ProductDto dto) {
        return ProductMapper.INSTANCE.map(
                repository.save(ProductMapper.INSTANCE.map(dto)
                ));
    }
}
