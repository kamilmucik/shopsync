package pl.estrix.shopsync.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto map(User source);

    @AfterMapping
    default void afterMapping(@MappingTarget UserDto target, User source) {
        target.setIdMap(source.getId().toString());
        target.setUserName(source.getFirstName());
        target.setUserLastname(source.getLastName());
    }

    User map(UserDto source);

}
