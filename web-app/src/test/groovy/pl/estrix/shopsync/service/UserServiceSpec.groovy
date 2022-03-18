package pl.estrix.shopsync.service

import org.springframework.security.crypto.password.PasswordEncoder
import pl.estrix.shopsync.commons.core.domain.paging.Column
import pl.estrix.shopsync.commons.core.domain.paging.Direction
import pl.estrix.shopsync.commons.core.domain.paging.Order
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest
import pl.estrix.shopsync.commons.core.domain.paging.Search
import pl.estrix.shopsync.commons.entity.ListResponseDto
import pl.estrix.shopsync.model.UserDto
import pl.estrix.shopsync.persist.user.executor.UserCommandExecutor
import pl.estrix.shopsync.service.impl.UserServiceImpl
import spock.lang.Specification

class UserServiceSpec extends Specification {

    def userExecutorMock = Mock(UserCommandExecutor)
    def passwordEncoderMock = Mock(PasswordEncoder)

    def userService = new UserServiceImpl(userExecutorMock, passwordEncoderMock)

    def "should use the executor to fetch list of User"() {
        given:
        def pagingRequest = preparePagingRequest()
        1 * userExecutorMock.find(_,_) >> findListDtoMock()

        when:
        def resultList = userService.getUsers(pagingRequest)

        then:
        !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch list of User by id without order"() {
        given:
        def pagingRequest = preparePagingRequest()
        pagingRequest.getOrder().clear()
        1 * userExecutorMock.find(_,_) >> findListDtoMock()

        when:
        def resultList = userService.getUsers(pagingRequest)

        then:
        !resultList.getData().isEmpty()
    }

    def "should use the executor to fetch one User by id"() {
        given:
        1 * userExecutorMock.getById(_) >> findDtoMock()

        when:
        def result = userService.getById(1)

        then:
        result.getId() == "1"
    }

    def "should use the executor to update User"() {
        given:
        def dto = findDtoMock()
        1 * userExecutorMock.update(_) >> findDtoMock()
        1 * passwordEncoderMock.encode(_) >> "hashhash"

        when:
        def result = userService.save(dto)

        then:
        result.getId() == "1"
    }

    def "should use the executor to save Settings"() {
        given:
        def dto = findDtoMock()
        dto.setId(null)
        1 * userExecutorMock.create(_) >> findDtoMock()
        1 * passwordEncoderMock.encode(_) >> "hashhash"

        when:
        def result = userService.save(dto)

        then:
        result.getId() == "1"
    }

    def "should use the executor to delete Settings"() {
        given:
        def dto = findDtoMock()
        1 * userExecutorMock.deleteById(_)

        when:
        userService.deleteById(1)

        then: "Don't know how condition should look like"
        1 == 1
    }

    def "should use the executor to get by login"() {
        given:
        def dto = findDtoMock()
        1 * userExecutorMock.getByEmail(_) >> findDtoMock()

        when:
        def result = userService.getByLogin("email")

        then:
        result.getId() == "1"
    }

    private UserDto findDtoMock(){
        UserDto dto = new UserDto()
        dto.setId("1")
        dto.setLocked(false)
        dto.setEnabled(true)
        dto.setRole("ROLE_USER")
        dto.setEmail("test@email.pl")
        dto.setUserName("UserName")
        dto.setPassword("Password")
        dto.setUserLastname("UserLastname")
        dto
    }

    private ListResponseDto<UserDto> findListDtoMock() {
        List<UserDto> settingList = new ArrayList<>()
        settingList.add(findDtoMock())
        ListResponseDto<UserDto> responseList = new ListResponseDto()
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
