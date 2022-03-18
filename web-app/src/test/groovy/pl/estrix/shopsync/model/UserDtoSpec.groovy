package pl.estrix.shopsync.model

import spock.lang.Specification

class UserDtoSpec extends Specification {

    UserDto dto = new UserDto()

    def "UserDto: should return name"() {
        when:
        dto.setIdMap(name)

        then:
        dto.getIdMap().equals(expected)
        dto.hashCode() instanceof Integer

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

    def "UserDto: should test equal: error 1"() {
        when:
        dto.setUserName("name")
        def dto2 = new UserDto()

        then:
        !dto.equals(dto2)
    }

    def "UserDto: should test equal: error 2"() {
        when:
        dto.setUserName("name")
        def dto2 = new SettingDto()

        then:
        !dto.equals(dto2)
    }

    def "UserDto: should test equal: same object"() {
        when:
        dto.setUserName("name")

        then:
        dto.equals(dto)
    }

    def "UserDto: should test equal: error null object"() {
        when:
        dto.setUserName("name")

        then:
        !dto.equals(null)
    }
}
