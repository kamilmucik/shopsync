package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.user.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
        @Mapping(target = "userName", source = "firstName"),
        @Mapping(target = "userLastname", source = "lastName"),
    })
    UserDto map(User source);

    @Mappings({
            @Mapping(target = "firstName", source = "userName"),
            @Mapping(target = "lastName", source = "userLastname"),
    })
    User map(UserDto source);

}
