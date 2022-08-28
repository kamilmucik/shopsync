package pl.estrix.shopsync.model

import spock.lang.Specification

class WarehouseDtoSpec extends Specification {

    WarehouseDto dto = new WarehouseDto()

    def "WarehouseDto: should return name"() {
        when:
        dto.setName(name)
        dto.setLastUpdate("202208262005")
        dto.setApiUrl("api-url")
        dto.setUrl("url")

        then:
        dto.getName().equals(expected)

        where:
        name            | expected
        "Warehouse1"    | "Warehouse1"
        "Warehouse2"    | "Warehouse2"
        "Warehouse3"    | "Warehouse3"
    }

    def "WarehouseDto: should test toString"() {
        when:
        dto.setName("11")

        then:
        !dto.toString().isEmpty()
    }

    def "WarehouseDto: should test equal"() {
        when:
        dto.setName(name)
        def dto2 = new WarehouseDto()
        dto2.setName(name)

        then:
        dto.equals(dto2)
        dto.hashCode() instanceof Integer

        where:
        name            | expected
        "Warehouse1"    | "Warehouse1"
        "Warehouse2"    | "Warehouse2"
        "Warehouse3"    | "Warehouse3"
    }


    def "WarehouseDto: should test equal: error 1"() {
        when:
        dto.setName("name")
        def dto2 = new UserDto()

        then:
        !dto.equals(dto2)
    }

    def "WarehouseDto: should test equal: same object"() {
        when:
        dto.setName("name")

        then:
        dto.equals(dto)
    }

    def "WarehouseDto: should test equal: error null object"() {
        when:
        dto.setName("name")

        then:
        !dto.equals(null)
    }
}
