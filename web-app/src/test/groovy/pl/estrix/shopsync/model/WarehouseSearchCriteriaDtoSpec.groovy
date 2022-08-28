package pl.estrix.shopsync.model

import spock.lang.Specification

class WarehouseSearchCriteriaDtoSpec extends Specification {

    WarehouseSearchCriteriaDto dto = new WarehouseSearchCriteriaDto()

    def "WarehouseSearchCriteriaDto: should return name"() {
        when:
        dto.setSearch(name)

        then:
        dto.getSearch() == expected

        where:
        name            | expected
        "Warehouse1"    | "Warehouse1"
        "Warehouse2"    | "Warehouse2"
        "Warehouse3"    | "Warehouse3"
    }

    def "WarehouseSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new WarehouseSearchCriteriaDto(name)

        then:
        lDto.getSearch() == expected

        where:
        name            | expected
        "Warehouse1"    | "Warehouse1"
        "Warehouse2"    | "Warehouse2"
        "Warehouse3"    | "Warehouse3"
    }

    def "WarehouseSearchCriteriaDto: should test Builder"(){
        when:
        def criteria = WarehouseSearchCriteriaDto.builder().search(name).build()

        then:
        criteria.getSearch() == expected

        where:
        name            | expected
        "Warehouse1"    | "Warehouse1"
        "Warehouse2"    | "Warehouse2"
        "Warehouse3"    | "Warehouse3"
    }
}
