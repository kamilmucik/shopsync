package pl.estrix.shopsync

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

/**
 * Integration test for App class.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = SpringBootWebApplication)
class SpringBootWebApplicationSpecIT extends Specification {

    @Autowired
    ApplicationContext context

    def "test context loads"() {
        expect:
        context != null
		context.containsBean("userCommandExecutor")
//		context.containsBean("helloWorldService")
//		context.containsBean("simpleBootApp")
//		context.containsBean("scopedHelloWorldService")
    }
}