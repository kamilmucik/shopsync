package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.ShopDto;
import pl.estrix.shopsync.persist.shop.model.ShopDao;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    ShopMapper INSTANCE = Mappers.getMapper(ShopMapper.class);

    ShopDto map(ShopDao source);

    ShopDao map(ShopDto source);
}
