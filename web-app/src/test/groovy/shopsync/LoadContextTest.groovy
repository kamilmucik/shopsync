package pl.estrix.shopsync

import org.springframework.beans.factory.annotation.Autowired
import pl.estrix.shopsync.controller.WebController
import shopsync.AbstractTest

class LoadContextTest extends AbstractTest{

    @Autowired (required = false)
    private WebController webController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        webController
    }
}
