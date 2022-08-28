package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import pl.estrix.shopsync.service.impl.ShopServiceImpl
import spock.lang.Specification

class ShopRestControllerSpec extends Specification {

    def serviceMock = Mock(ShopServiceImpl)
    def restController = new ShopRestController(serviceMock)

    def "should ask the ShopService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        restController.list(pagingRequest)

        then:
        1 * serviceMock.getList(pagingRequest)
    }
}
