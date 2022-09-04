package pl.estrix.shopsync.controller

import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.service.impl.EventLogServiceImpl
import pl.estrix.shopsync.service.impl.SettingServiceImpl

class EventLogControllerSpec extends ControllerSpec {

    def service = Mock(EventLogServiceImpl)
    def bindingResult = Mock(BindingResult);
    def controller = new EventLogController(service)

    def "should show EventLog event log page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.eventLog(model)

        then:
        page == "eventlog/index"
    }

    def "should show EventLog index page"() {
        when:
        def page = controller.index()

        then:
        page == "eventlog/index"
    }
}
