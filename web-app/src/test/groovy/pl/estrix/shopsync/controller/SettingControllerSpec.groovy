package pl.estrix.shopsync.controller

import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.service.impl.SettingServiceImpl

class SettingControllerSpec extends ControllerSpec {

    def service = Mock(SettingServiceImpl)
    def bindingResult = Mock(BindingResult);
    def controller = new SettingController(service)

    def "should show Setting index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.setting(model)

        then:
        page == "setting/index"
    }

    def "should show Setting form page"() {
        when:
        def page = controller.form()

        then:
        page == "setting/form"
    }

    def "should save Setting: error"() {
        given:
        def settingDto = prepareSettingDto()
        1 * bindingResult.hasErrors() >> true

        when:
        def page = controller.save(settingDto,bindingResult)

        then:
        page == "setting/form"
    }

    def "should save Setting: no error"() {
        given:
        def settingDto = prepareSettingDto()

        when:
        def page = controller.save(settingDto,bindingResult)

        then:
        page == "redirect:/setting/"
    }

    def "should show edit Setting"() {
        given:
        def settingDto = prepareSettingDto()

        when:
        def page = controller.edit("1",createDefaultModel())

        then:
        page == "setting/form"
    }

    def SettingDto prepareSettingDto() {
        SettingDto settingDto = new SettingDto()
        settingDto
    }
}
