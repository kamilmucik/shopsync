package pl.estrix.shopsync.mapper


import pl.estrix.shopsync.model.UserDto
import pl.estrix.shopsync.persist.user.model.User
import spock.lang.Specification

class UserMapperSpec extends Specification{

    def "UserMapper: Should map Entity to DTO"(){
        given:
        UserDto userDto = UserDto.builder().email("email").idMap("1").build()

        when:
        def user = UserMapper.INSTANCE.map(userDto)

        then:
        user.getEmail() == userDto.getEmail()
    }

    def "UserMapper: Should map DTO to Entity"(){
        given:
        User user = User.builder().email("email").id(1L).build()

        when:
        def userDto = UserMapper.INSTANCE.map(user)

        then:
        userDto.getEmail() == user.getEmail()
    }
}
