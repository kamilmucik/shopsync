package pl.estrix.shopsync.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.user.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-24T01:34:29+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto map(User source) {
        if ( source == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUserName( source.getFirstName() );
        userDto.setUserLastname( source.getLastName() );
        userDto.setId( source.getId() );
        userDto.setEmail( source.getEmail() );
        userDto.setPassword( source.getPassword() );
        userDto.setRole( source.getRole() );
        userDto.setEnabled( source.isEnabled() );
        userDto.setLocked( source.isLocked() );

        afterMapping( userDto, source );

        return userDto;
    }

    @Override
    public User map(UserDto source) {
        if ( source == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( source.getUserName() );
        user.setLastName( source.getUserLastname() );
        user.setId( source.getId() );
        user.setEmail( source.getEmail() );
        user.setPassword( source.getPassword() );
        user.setEnabled( source.isEnabled() );
        user.setLocked( source.isLocked() );
        user.setRole( source.getRole() );

        return user;
    }
}
