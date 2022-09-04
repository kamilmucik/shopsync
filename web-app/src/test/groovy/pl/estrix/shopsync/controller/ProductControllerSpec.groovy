package pl.estrix.shopsync.controller

import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.ProductDto
import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.service.impl.ProductServiceImpl
import pl.estrix.shopsync.service.impl.SettingServiceImpl

class ProductControllerSpec extends ControllerSpec {

    def service = Mock(ProductServiceImpl)
    def bindingResult = Mock(BindingResult);
    def controller = new ProductController(service)

    def "should show Product index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.product(model)

        then:
        page == "product/index"
    }

    def "should show Product add page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.add(model)

        then:
        page == "product/form"
    }

    def "should show Product form page"() {
        when:
        def page = controller.form()

        then:
        page == "product/form"
    }

    def "should save Product: error"() {
        given:
        def dto = prepareDto()
        1 * bindingResult.hasErrors() >> true

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "product/form"
    }

    def "should save Product: no error"() {
        given:
        def dto = prepareDto()

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "redirect:/product/"
    }

    def "should show edit Product"() {
        given:
        def dto = prepareDto()

        when:
        def page = controller.edit("1",createDefaultModel())

        then:
        page == "product/form"
    }

    def ProductDto prepareDto() {
        ProductDto dto = new ProductDto()
        dto
    }
}
