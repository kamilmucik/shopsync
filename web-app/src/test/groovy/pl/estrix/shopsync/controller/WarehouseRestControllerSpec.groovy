package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.WarehouseServiceImpl
import spock.lang.Specification

class WarehouseRestControllerSpec extends Specification {

    def serviceMock = Mock(WarehouseServiceImpl)
    def restController = new WarehouseRestController(serviceMock)

    def "should ask the WarehouseService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        restController.list(pagingRequest)

        then:
        1 * serviceMock.getList(pagingRequest)
    }
}
