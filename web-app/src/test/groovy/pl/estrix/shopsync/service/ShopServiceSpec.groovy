package pl.estrix.shopsync.service

import pl.estrix.shopsync.commons.core.domain.paging.*
import pl.estrix.shopsync.commons.entity.ListResponseDto
import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.model.ShopDto
import pl.estrix.shopsync.persist.setting.SettingCommandExecutor
import pl.estrix.shopsync.persist.shop.ShopCommandExecutor
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import pl.estrix.shopsync.service.impl.ShopServiceImpl
import spock.lang.Specification

class ShopServiceSpec extends Specification {

    def executorMock = Mock(ShopCommandExecutor)

    def service = new ShopServiceImpl(executorMock)

    def "should use the executor to fetch list of Shop by id"() {
        given:
            def pagingRequest = preparePagingRequest()
            1 * executorMock.find(_,_) >> findListDtoMock()

        when:
            def resultList = service.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch list of Shop by id without order"() {
        given:
            def pagingRequest = preparePagingRequest()
            pagingRequest.getOrder().clear()
            1 * executorMock.find(_,_) >> findListDtoMock()

        when:
            def resultList = service.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch one Shop by id"() {
        given:
            1 * executorMock.getById(_) >> findDtoMock()

        when:
            def result = service.getById(1)

        then:
            result.getId() == 1
    }

    def "should use the executor to update Shop"() {
        given:
            def setting = findDtoMock()
            1 * executorMock.getById(_) >> findDtoMock()
            1 * executorMock.update(_) >> findDtoMock()

        when:
            def result = service.save(setting)

        then:
            result.getId() == 1
    }

    def "should use the executor to save Shop"() {
        given:
            def setting = findDtoMock()
            setting.setId(null)
            1 * executorMock.create(_) >> findDtoMock()

        when:
            def result = service.save(setting)

        then:
            result.getId() == 1
    }

    private ShopDto findDtoMock(){
        ShopDto dto = new ShopDto()
        dto.setId(1L)
        dto.setName("test")
        dto.setLastUpdate("202208262005")
        dto.setApiUrl("api-url")
        dto.setUrl("url")
        dto
    }

    private ListResponseDto<ShopDto> findListDtoMock() {
        List<ShopDto> settingList = new ArrayList<>()
        settingList.add(findDtoMock())
        ListResponseDto<ShopDto> responseList = new ListResponseDto()
        responseList.setTotalCount(1)
        responseList.setData(settingList)

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
