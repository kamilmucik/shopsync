package pl.estrix.shopsync.model

import spock.lang.Specification

class UserPasswordDtoSpec extends Specification {

    UserPasswordDto dto = UserPasswordDto.builder().build()


    def "UserPasswordDto: should return name"() {
        when:
        dto.setLogin(name)

        then:
        dto.getLogin().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }

    def "UserPasswordDto: should test Builder"(){
        when:
        def version = UserPasswordDto.builder().login(name).build()

        then:
        version.getLogin().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "UserPasswordDto: should test toString"(){
        when:
        def version = UserPasswordDto.builder().login("name").build()

        then:
        version.toString() instanceof String

    }

    def "UserDto: should test equal"() {
        when:
        dto.setLogin("login")
        def dto2 =  UserPasswordDto.builder().login("login").build()

        then:
        dto.equals(dto2)
    }

    def "UserDto: should test equal: error 1"() {
        when:
        dto.setLogin("name")
        def dto2 = new UserDto()

        then:
        !dto.equals(dto2)
    }

//    def "UserDto: should test equal: error 2"() {
//        when:
//        dto.setLogin("name")
//        def dto2 = new SettingDto()
//
//        then:
//        !dto.equals(dto2)
//    }

    def "UserDto: should test equal: same object"() {
        when:
        dto.setLogin("name")

        then:
        dto.equals(dto)
    }

    def "UserDto: should test equal: error null object"() {
        when:
        dto.setLogin("name")

        then:
        !dto.equals(null)
    }
}
