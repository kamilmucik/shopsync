package pl.estrix.shopsync.model

import spock.lang.Specification

class ProductSearchCriteriaDtoSpec extends Specification {

    ProductSearchCriteriaDto dto = new ProductSearchCriteriaDto()

    def "ProductSearchCriteriaDto: should return name"() {
        when:
        dto.setSearch(name)

        then:
        dto.getSearch().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }


    def "ProductSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new ProductSearchCriteriaDto(name)

        then:
        lDto.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "ProductSearchCriteriaDto: should test Builder"(){
        when:
        def dtop = ProductSearchCriteriaDto.builder().search(name).build()

        then:
        dtop.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }
}
