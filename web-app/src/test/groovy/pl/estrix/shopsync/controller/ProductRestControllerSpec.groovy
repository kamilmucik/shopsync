package pl.estrix.shopsync.controller

import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.service.impl.ProductServiceImpl
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import spock.lang.Specification

class ProductRestControllerSpec extends Specification {

    def serviceMock = Mock(ProductServiceImpl)
    def restController = new ProductRestController(serviceMock)

    def "should ask the ProductService for list"() {
        given:
        PagingRequest pagingRequest = new PagingRequest()

        when:
        restController.list(pagingRequest)

        then:
        1 * serviceMock.getList(pagingRequest)
    }
}
