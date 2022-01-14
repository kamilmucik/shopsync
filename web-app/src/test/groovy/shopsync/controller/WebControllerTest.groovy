package pl.estrix.shopsync.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import shopsync.AbstractTest
import spock.lang.Specification

@WebMvcTest
//@SpringBootTest
//@ContextConfiguration(classes = [WebController.class])
//@WebMvcTest(WebController.class)
class WebControllerTest extends AbstractTest{

    @Autowired
    private MockMvc mvc;

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello world!"
    }
}
