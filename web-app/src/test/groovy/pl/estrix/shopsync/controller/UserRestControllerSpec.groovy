package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.UserServiceImpl
import spock.lang.Specification

class UserRestControllerSpec extends Specification {

    def userServiceMock = Mock(UserServiceImpl)
    def userRestController = new UserRestController(userServiceMock)

    def "should ask the UserService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        userRestController.list(pagingRequest)

        then:
        1 * userServiceMock.getUsers(pagingRequest)
    }
}
