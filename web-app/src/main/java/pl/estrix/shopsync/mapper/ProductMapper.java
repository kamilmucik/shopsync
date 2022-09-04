package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.ProductDto;
import pl.estrix.shopsync.persist.product.model.ProductDao;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto map(ProductDao source);

    ProductDao map(ProductDto source);

}
