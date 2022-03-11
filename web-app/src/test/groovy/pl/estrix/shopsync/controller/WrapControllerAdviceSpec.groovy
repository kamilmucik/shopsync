package pl.estrix.shopsync.controller

import org.springframework.boot.info.BuildProperties
import org.springframework.mock.web.MockHttpServletRequest
import spock.lang.Specification

import java.time.OffsetDateTime

class WrapControllerAdviceSpec extends Specification {

//    def buildProperties = prepareBuildProperties()
//    def controller = new WrapControllerAdvice(buildProperties)

    def "some meaningless test"(){
        given:
        def servletRequest = new MockHttpServletRequest()

        when:
        1+1

        then:
        true
    }

//    def BuildProperties prepareBuildProperties() {
//        final Properties p = new Properties();
//        p.setProperty("build.time", OffsetDateTime.now().toString())
//        return new BuildProperties(p)
//    }
//    def "should test"() {
//        given:
//        def servletRequest = new MockHttpServletRequest()
//
//        when:
//        1+1
////        controller.handleRequest(servletRequest , null)
//
//        then:
//        true
//    }
}
