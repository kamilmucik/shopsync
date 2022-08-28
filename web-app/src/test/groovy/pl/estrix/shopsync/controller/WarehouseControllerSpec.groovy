package pl.estrix.shopsync.controller

import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.WarehouseDto
import pl.estrix.shopsync.service.impl.WarehouseServiceImpl

class WarehouseControllerSpec extends ControllerSpec {

    def service = Mock(WarehouseServiceImpl)
    def bindingResult = Mock(BindingResult);
    def controller = new WarehouseController(service)

    def "should show Warehouse index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.warehouse(model)

        then:
        page == "warehouse/index"
    }

    def "should show Warehouse form page"() {
        when:
        def page = controller.form()

        then:
        page == "warehouse/form"
    }

    def "should save Warehouse: error"() {
        given:
        def dto = prepareWarehouseDto()
        1 * bindingResult.hasErrors() >> true

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "warehouse/form"
    }

    def "should save Warehouse: no error"() {
        given:
        def dto = prepareWarehouseDto()

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "redirect:/warehouse/"
    }

    def "should show add Warehouse"() {
        given:
        def dto = prepareWarehouseDto()

        when:
        def page = controller.add(createDefaultModel())

        then:
        page == "warehouse/form"
    }

    def "should show edit Warehouse"() {
        given:
        def dto = prepareWarehouseDto()

        when:
        def page = controller.edit("1",createDefaultModel())

        then:
        page == "warehouse/form"
    }

    def WarehouseDto prepareWarehouseDto() {
        WarehouseDto dto = new WarehouseDto()
        dto.setId(1L)
        dto.setLastUpdate("20220826203500")
        dto.setName("WarehouseName")
        dto.setApiUrl("api-url")
        dto.setUrl("url")
        dto
    }
}
