package pl.estrix.shopsync.model

import spock.lang.Specification

class SettingDtoSpec extends Specification {

    SettingDto dto = new SettingDto()

    def "UserDto: should return name"() {
        when:
        dto.setName(name)
        dto.setType(name)
        dto.setCode(name)
        dto.setValue(name)

        then:
        dto.getName().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }

    def "UserDto: should test toString"() {
        when:
        dto.setName("11")

        then:
        !dto.toString().isEmpty()
    }

    def "UserDto: should test equal"() {
        when:
        dto.setValue(name)
        def dto2 = new SettingDto()
        dto2.setValue(name)

        then:
        dto.equals(dto2)
        dto.hashCode() instanceof Integer

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }


    def "UserDto: should test equal: error 1"() {
        when:
        dto.setValue("name")
        def dto2 = new UserDto()

        then:
        !dto.equals(dto2)
    }

    def "UserDto: should test equal: same object"() {
        when:
        dto.setValue("name")

        then:
        dto.equals(dto)
    }

    def "UserDto: should test equal: error null object"() {
        when:
        dto.setValue("name")

        then:
        !dto.equals(null)
    }
}
