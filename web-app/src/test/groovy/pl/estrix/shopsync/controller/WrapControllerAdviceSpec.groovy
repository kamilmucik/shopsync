package pl.estrix.shopsync.controller

import org.springframework.boot.info.BuildProperties
import org.springframework.mock.web.MockHttpServletRequest
import pl.estrix.shopsync.tool.UserUtil

import java.time.OffsetDateTime

class WrapControllerAdviceSpec extends ControllerSpec {

    def buildProperties = prepareBuildProperties()
    def userUtil = Mock(UserUtil)
    def controller = new WrapControllerAdvice(buildProperties, userUtil)

    def "Should test default handler"(){
        given:
        def servletRequest = new MockHttpServletRequest()
        1 * userUtil.getCurrentUserName() >> "userName"

        when:
        controller.handleRequest(servletRequest,createDefaultModel())

        then:
        true
    }

    def BuildProperties prepareBuildProperties() {
        final Properties p = new Properties();
        p.setProperty("build.time", OffsetDateTime.now().toString())
        p.setProperty("version", "0.0.1")
        BuildProperties buildProperties = new BuildProperties(p)
        buildProperties
    }

}
