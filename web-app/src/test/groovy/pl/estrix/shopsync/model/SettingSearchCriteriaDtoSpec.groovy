package pl.estrix.shopsync.model

import spock.lang.Specification

class SettingSearchCriteriaDtoSpec extends Specification {

    SettingSearchCriteriaDto dto = new SettingSearchCriteriaDto()

    def "SettingSearchCriteriaDto: should return name"() {
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


    def "SettingSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new SettingSearchCriteriaDto(name)

        then:
        lDto.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "SettingSearchCriteriaDto: should test Builder"(){
        when:
        def version = SettingSearchCriteriaDto.builder().search(name).build()

        then:
        version.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }
}
