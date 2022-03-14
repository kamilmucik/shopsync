package pl.estrix.shopsync.service

import pl.estrix.shopsync.commons.core.domain.paging.Column
import pl.estrix.shopsync.commons.core.domain.paging.Direction
import pl.estrix.shopsync.commons.core.domain.paging.Order
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.commons.core.domain.paging.Search
import pl.estrix.shopsync.commons.entity.ListResponseDto
import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.persist.setting.SettingCommandExecutor
import pl.estrix.shopsync.service.impl.SettingServiceImpl
import spock.lang.Specification

class SettingServiceSpec extends Specification {

    def settingExecutorMock = Mock(SettingCommandExecutor)

    def settingService = new SettingServiceImpl(settingExecutorMock)

    def "should use the executor to fetch list of Settings by id"() {
        given:
            def pagingRequest = preparePagingRequest()
            1 * settingExecutorMock.find(_,_) >> findSettingListDtoMock()

        when:
            def resultList = settingService.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch list of Settings by id without order"() {
        given:
            def pagingRequest = preparePagingRequest()
            pagingRequest.getOrder().clear()
            1 * settingExecutorMock.find(_,_) >> findSettingListDtoMock()

        when:
            def resultList = settingService.getList(pagingRequest)

        then:
            !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch one Settings by id"() {
        given:
            1 * settingExecutorMock.getById(_) >> findSettingDtoMock()

        when:
            def result = settingService.getById(1)

        then:
            result.getId() == 1
    }

    def "should use the executor to update Settings"() {
        given:
            def setting = findSettingDtoMock()
            1 * settingExecutorMock.getById(_) >> findSettingDtoMock()
            1 * settingExecutorMock.update(_) >> findSettingDtoMock()

        when:
            def result = settingService.save(setting)

        then:
            result.getId() == 1
    }

    def "should use the executor to save Settings"() {
        given:
            def setting = findSettingDtoMock()
            setting.setId(null)
            1 * settingExecutorMock.getById(_) >> findSettingDtoMock()
            1 * settingExecutorMock.create(_) >> findSettingDtoMock()

        when:
            def result = settingService.save(setting)

        then:
            result.getId() == 1
    }

    private SettingDto findSettingDtoMock(){
        SettingDto settingDto = new SettingDto()
        settingDto.setId(1L)
        settingDto.setName("test")
        settingDto.setValue("test")
        settingDto
    }

    private ListResponseDto<SettingDto> findSettingListDtoMock() {
        List<SettingDto> settingList = new ArrayList<>()
        settingList.add(findSettingDtoMock())
        ListResponseDto<SettingDto> responseList = new ListResponseDto()
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
