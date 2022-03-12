package pl.estrix.shopsync.model

import spock.lang.Specification

class UserDtoSpec extends Specification {

    UserDto dto = new UserDto()

    def "UserDto: should return name"() {
        when:
        dto.setIdMap(name)

        then:
        dto.getIdMap().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }

    def "UserDto: should test toString"() {
        when:
        dto.setIdMap("11")

        then:
        !dto.toString().isEmpty()
    }

    def "UserDto: should test equal"() {
        when:
        dto.setIdMap("11")
        def dto2 = new UserDto()
        dto2.setIdMap("11")

        then:
        dto.equals(dto2)
    }
}
