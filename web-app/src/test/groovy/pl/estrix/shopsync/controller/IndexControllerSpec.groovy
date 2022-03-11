package pl.estrix.shopsync.controller

import org.springframework.ui.Model

class IndexControllerSpec extends ControllerSpec {


    def controller = new IndexController()

    def "should show index page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.index(model)

        then:
        page == "index"
    }

    def "should show login page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.login(model)

        then:
        page == "login"
    }

    def "should show error 403 page"() {
        given:
        Model model = createDefaultModel()

        when:
        def page = controller.error403(model)

        then:
        page == "error/403"
    }
}
