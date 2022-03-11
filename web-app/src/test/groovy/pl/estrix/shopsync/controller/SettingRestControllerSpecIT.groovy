package pl.estrix.shopsync.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


/**
 * Integration Test for UserRest Controller.
 */
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class SettingRestControllerSpecIT extends Specification {

    @Autowired
    private MockMvc mockMvc

    @WithMockUser
    def "should return planet earth details as JSON"() {
        given:
        Map request = [
                draw : 1,
//                columns: [
//                        data: "firstName",
//                        name: "",
//                        searchable: true,
//                        orderable: true,
//                        search: [
//                            "value": "",
//                            "regex": false
//                        ]
//                ],
//                "order": [
//                              column: 0,
//                              dir: "asc"
//
//                ],
                start: 0,
                length: 5,
//                search: [
//                    value: "",
//                    regex: false
//                ]

        ]

        when:
        def response = mockMvc.perform(
                post("/setting/list")
                        .contentType(APPLICATION_JSON_UTF8)
//                .content(toJson(request))
                        .content("{\"draw\":1,\"columns\":[{\"data\":\"name\",\"name\":\"\",\"searchable\":true,\"orderable\":true,\"search\":{\"value\":\"\",\"regex\":false}},{\"data\":\"code\",\"name\":\"\",\"searchable\":true,\"orderable\":true,\"search\":{\"value\":\"\",\"regex\":false}},{\"data\":\"value\",\"name\":\"\",\"searchable\":true,\"orderable\":true,\"search\":{\"value\":\"\",\"regex\":false}},{\"data\":\"type\",\"name\":\"\",\"searchable\":true,\"orderable\":true,\"search\":{\"value\":\"\",\"regex\":false}},{\"data\":\"id\",\"name\":\"\",\"searchable\":true,\"orderable\":false,\"search\":{\"value\":\"\",\"regex\":false}}],\"order\":[{\"column\":0,\"dir\":\"asc\"}],\"start\":0,\"length\":5,\"search\":{\"value\":\"\",\"regex\":false}}")
        )

        then:
        response
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
        and:
        response.andExpect(jsonPath('$.data').isArray())

    }
}
