package pl.estrix.shopsync.model

import spock.lang.Specification

class ShopDtoSpec extends Specification {

    ShopDto dto = new ShopDto()

    def "ShopDto: should return name"() {
        when:
        dto.setName(name)
        dto.setLastUpdate("202208262005")
        dto.setApiUrl("api-url")
        dto.setUrl("url")

        then:
        dto.getName().equals(expected)

        where:
        name       | expected
        "shop1"    | "shop1"
        "shop2"    | "shop2"
        "shop3"    | "shop3"
    }

    def "ShopDto: should test toString"() {
        when:
        dto.setName("11")

        then:
        !dto.toString().isEmpty()
    }

    def "ShopDto: should test equal"() {
        when:
        dto.setName(name)
        def dto2 = new ShopDto()
        dto2.setName(name)

        then:
        dto.equals(dto2)
        dto.hashCode() instanceof Integer

        where:
        name       | expected
        "shop1"    | "shop1"
        "shop2"    | "shop2"
        "shop3"    | "shop3"
    }


    def "ShopDto: should test equal: error 1"() {
        when:
        dto.setName("name")
        def dto2 = new UserDto()

        then:
        !dto.equals(dto2)
    }

    def "ShopDto: should test equal: same object"() {
        when:
        dto.setName("name")

        then:
        dto.equals(dto)
    }

    def "ShopDto: should test equal: error null object"() {
        when:
        dto.setName("name")

        then:
        !dto.equals(null)
    }
}
