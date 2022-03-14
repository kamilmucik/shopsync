package pl.estrix.shopsync.service

import pl.estrix.shopsync.model.UserDto
import pl.estrix.shopsync.persist.user.executor.UserCommandExecutor
import pl.estrix.shopsync.service.impl.UserLoginServiceExtImpl
import spock.lang.Specification

class UserLoginServiceExtSpec extends Specification {

    def userCommandExecutorMock = Mock(UserCommandExecutor)

    def userLoginServiceExt = new UserLoginServiceExtImpl(userCommandExecutorMock)

    def "should use the executor to fetch list of Settings by id"() {
        given:
            def email = "test@email.com"
            1 * userCommandExecutorMock.getByEmail(_) >> prepareUserDtoMock()

        when:
            def result = userLoginServiceExt.loadUserByUsername(email)

        then:
            !result.getUsername().isEmpty()
    }

    def UserDto prepareUserDtoMock() {
        UserDto userDto = new UserDto()
        userDto.setId("1")
        userDto.setUserName("Test")
        userDto.setPassword("password")
        userDto.setEmail("test@email.com")
        userDto.setRole("ROLE_USER")
        userDto.setEnabled(true)
        userDto.setLocked(false)
        userDto
    }
}
