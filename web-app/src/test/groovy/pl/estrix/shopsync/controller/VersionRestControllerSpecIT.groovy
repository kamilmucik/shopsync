package pl.estrix.shopsync.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import pl.estrix.shopsync.model.VersionDto
import pl.estrix.shopsync.persist.version.VersionExecutor
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import static org.hamcrest.Matchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Integration Test for Version Controller.
 */
@SpringBootTest
@AutoConfigureMockMvc
class VersionRestControllerSpecIT extends Specification{

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private VersionExecutor planetRepo

    def "should return planet earth details as JSON"() {
        given:
        VersionDto earth = new VersionDto()
        earth.setVersion("0.0.1")
        planetRepo.add(earth)

        when:
        def response = mockMvc.perform(
                get("/version")
        )

        then:
        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath('$.version', is('0.0.1')))
    }
}
