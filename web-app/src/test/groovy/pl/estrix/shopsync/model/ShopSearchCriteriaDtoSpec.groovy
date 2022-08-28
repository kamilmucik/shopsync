package pl.estrix.shopsync.model

import spock.lang.Specification

class ShopSearchCriteriaDtoSpec extends Specification {

    ShopSearchCriteriaDto dto = new ShopSearchCriteriaDto()

    def "ShopSearchCriteriaDto: should return name"() {
        when:
        dto.setSearch(name)

        then:
        dto.getSearch() == expected

        where:
        name       | expected
        "shop1"    | "shop1"
        "shop2"    | "shop2"
        "shop3"    | "shop3"
    }

    def "ShopSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new ShopSearchCriteriaDto(name)

        then:
        lDto.getSearch() == expected

        where:
        name       | expected
        "shop1"    | "shop1"
        "shop2"    | "shop2"
        "shop3"    | "shop3"
    }

    def "ShopSearchCriteriaDto: should test Builder"(){
        when:
        def criteria = ShopSearchCriteriaDto.builder().search(name).build()

        then:
        criteria.getSearch() == expected

        where:
        name       | expected
        "shop1"    | "shop1"
        "shop2"    | "shop2"
        "shop3"    | "shop3"
    }
}
