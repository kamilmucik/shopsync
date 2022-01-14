package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.PlatformDto;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;
import pl.estrix.shopsync.persist.user.model.User;

@Mapper(componentModel = "spring")
public interface PlatformMapper {

    PlatformMapper INSTANCE = Mappers.getMapper(PlatformMapper.class);

    PlatformDto map(PlatformEntry source);

    PlatformEntry map(PlatformDto source);

}
