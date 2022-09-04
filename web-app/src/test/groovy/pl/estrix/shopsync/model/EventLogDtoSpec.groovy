package pl.estrix.shopsync.model

import spock.lang.Specification

import java.time.LocalDateTime

class EventLogDtoSpec extends Specification {

    EventLogDto dto = new EventLogDto()

    def "EventLogDto: should return log"() {
        when:
        dto.setLastUpdated(LocalDateTime.now())
        dto.setType(name)
        dto.setLog(name)

        then:
        dto.getLog().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }

    def "EventLogDto: should test toString"() {
        when:
        dto.setLog("11")

        then:
        !dto.toString().isEmpty()
    }

    def "EventLogDto: should test equal"() {
        when:
        dto.setLog(name)
        def dto2 = new EventLogDto()
        dto2.setLog(name)

        then:
        dto.equals(dto2)
        dto.hashCode() instanceof Integer

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }


    def "EventLogDto: should test equal: error 1"() {
        when:
        dto.setLog("name")
        def dto2 = new EventLogDto()

        then:
        !dto.equals(dto2)
    }

    def "EventLogDto: should test equal: same object"() {
        when:
        dto.setLog("name")

        then:
        dto.equals(dto)
    }

    def "EventLogDto: should test equal: error null object"() {
        when:
        dto.setLog("name")

        then:
        !dto.equals(null)
    }
}
