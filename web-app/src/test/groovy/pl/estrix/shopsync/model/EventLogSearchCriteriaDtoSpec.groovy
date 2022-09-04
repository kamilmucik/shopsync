package pl.estrix.shopsync.model

import spock.lang.Specification

class EventLogSearchCriteriaDtoSpec extends Specification {

    EventLogSearchCriteriaDto dto = new EventLogSearchCriteriaDto()

    def "EventLogSearchCriteriaDto: should return name"() {
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


    def "EventLogSearchCriteriaDto: should test allArgsConstructor"(){
        when:
        def lDto = new EventLogSearchCriteriaDto(name)

        then:
        lDto.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "EventLogSearchCriteriaDto: should test Builder"(){
        when:
        def dtop = EventLogSearchCriteriaDto.builder().search(name).build()

        then:
        dtop.getSearch().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }
}
