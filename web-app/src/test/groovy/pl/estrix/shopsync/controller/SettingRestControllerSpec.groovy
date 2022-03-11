package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import spock.lang.Specification

class SettingRestControllerSpec extends Specification {

    def serviceMock = Mock(SettingServiceImpl)
    def restController = new SettingRestController(serviceMock)

    def "should ask the UserService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        restController.list(pagingRequest)

        then:
        1 * serviceMock.getList(pagingRequest)
    }
}
