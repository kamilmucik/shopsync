package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.EventLogServiceImpl
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import spock.lang.Specification

class EventLogRestControllerSpec extends Specification {

    def serviceMock = Mock(EventLogServiceImpl)
    def restController = new EventLogRestController(serviceMock)

    def "should ask the UserService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        restController.list(pagingRequest)

        then:
        1 * serviceMock.getList(pagingRequest)
    }
}
