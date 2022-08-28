package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.WarehouseDto;
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao;

@Mapper(componentModel = "spring")
public interface WarehouseMapper {

    WarehouseMapper INSTANCE = Mappers.getMapper(WarehouseMapper.class);

    WarehouseDto map(WarehouseDao source);

    WarehouseDao map(WarehouseDto source);
}
