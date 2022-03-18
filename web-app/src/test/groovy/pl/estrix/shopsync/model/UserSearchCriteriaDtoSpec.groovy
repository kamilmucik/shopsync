package pl.estrix.shopsync.model

import spock.lang.Specification

class UserSearchCriteriaDtoSpec extends Specification {

    UserSearchCriteriaDto dto = new UserSearchCriteriaDto()

    def "UserSearchCriteriaDto: should return name"() {
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


    def "UserSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new SettingSearchCriteriaDto(name)

        then:
        lDto.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "UserSearchCriteriaDto: should test Builder"(){
        when:
        def version = SettingSearchCriteriaDto.builder().search(name).build()

        then:
        version.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }
}
