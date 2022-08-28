package pl.estrix.shopsync.controller

import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.ShopDto
import pl.estrix.shopsync.service.impl.ShopServiceImpl

class ShopControllerSpec extends ControllerSpec {

    def service = Mock(ShopServiceImpl)
    def bindingResult = Mock(BindingResult);
    def controller = new ShopController(service)

    def "should show Shop index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.shop(model)

        then:
        page == "shop/index"
    }

    def "should show Shop form page"() {
        when:
        def page = controller.form()

        then:
        page == "shop/form"
    }

    def "should save Shop: error"() {
        given:
        def dto = prepareShopDto()
        1 * bindingResult.hasErrors() >> true

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "shop/form"
    }

    def "should save Shop: no error"() {
        given:
        def dto = prepareShopDto()

        when:
        def page = controller.save(dto,bindingResult)

        then:
        page == "redirect:/shop/"
    }

    def "should show add Shop"() {
        given:
        def dto = prepareShopDto()

        when:
        def page = controller.add(createDefaultModel())

        then:
        page == "shop/form"
    }

    def "should show edit Shop"() {
        given:
        def dto = prepareShopDto()

        when:
        def page = controller.edit("1",createDefaultModel())

        then:
        page == "shop/form"
    }

    def ShopDto prepareShopDto() {
        ShopDto dto = new ShopDto()
        dto.setId(1L)
        dto.setLastUpdate("20220826203500")
        dto.setName("shopName")
        dto.setApiUrl("api-url")
        dto.setUrl("url")
        dto
    }
}
