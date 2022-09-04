package pl.estrix.shopsync.service

import pl.estrix.shopsync.commons.core.domain.paging.*
import pl.estrix.shopsync.commons.entity.ListResponseDto
import pl.estrix.shopsync.model.ProductDto
import pl.estrix.shopsync.persist.product.ProductCommandExecutor
import pl.estrix.shopsync.service.impl.ProductServiceImpl
import spock.lang.Specification

class ProductServiceSpec extends Specification {

    def executorMock = Mock(ProductCommandExecutor)

    def service = new ProductServiceImpl(executorMock)

    def "should use the executor to fetch list of Product by id"() {
        given:
            def pagingRequest = preparePagingRequest()
            1 * executorMock.find(_,_) >> findListDtoMock()

        when:
            def resultList = service.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch list of Product by id without order"() {
        given:
            def pagingRequest = preparePagingRequest()
            pagingRequest.getOrder().clear()
            1 * executorMock.find(_,_) >> findListDtoMock()

        when:
            def resultList = service.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch one Product by id"() {
        given:
            1 * executorMock.getById(_) >> findDtoMock()

        when:
            def result = service.getById(1)

        then:
            result.getId() == 1
    }

    def "should use the executor to update Product"() {
        given:
            def dto = findDtoMock()
            1 * executorMock.getById(_) >> findDtoMock()
            1 * executorMock.update(_) >> findDtoMock()

        when:
            def result = service.save(dto)

        then:
            result.getId() == 1
    }

    def "should use the executor to save Product"() {
        given:
            def dto = findDtoMock()
            dto.setId(null)
            1 * executorMock.create(_) >> findDtoMock()

        when:
            def result = service.save(dto)

        then:
            result.getId() == 1
    }

    private ProductDto findDtoMock(){
        ProductDto dto = new ProductDto()
        dto.setId(1L)
        dto.setName("test")
        dto.setDescription("test")
        dto.setAmount("test")
        dto.setMainImg("img")
        dto
    }

    private ListResponseDto<ProductDto> findListDtoMock() {
        List<ProductDto> list = new ArrayList<>()
        list.add(findDtoMock())
        ListResponseDto<ProductDto> responseList = new ListResponseDto()
        responseList.setTotalCount(1)
        responseList.setData(list)

        responseList
    }

    private PagingRequest preparePagingRequest(){
        PagingRequest pagingRequest = new PagingRequest()
        List<Order> orderList = new ArrayList<>()
        List<Column> columnList = new ArrayList<>()
        Order order = new Order()
        Column column = new Column()
        order.setColumn(0)
        order.setDir(Direction.asc)
        column.setData("id")
        column.setName("id")
        column.setSearchable(true)
        column.setOrderable(true)
        Search search = new Search()
        search.setValue("")
        column.setSearch(search)


        orderList.add(order)
        columnList.add(column)

        pagingRequest.setDraw(1)
        pagingRequest.setOrder(orderList)
        pagingRequest.setColumns(columnList)
        pagingRequest.setLength(5)
        pagingRequest.setStart(0)
        pagingRequest.setSearch(search)

        pagingRequest
    }
}
