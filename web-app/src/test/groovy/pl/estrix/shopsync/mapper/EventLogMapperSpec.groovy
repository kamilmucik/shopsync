package pl.estrix.shopsync.mapper

import pl.estrix.shopsync.model.EventLogDto
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao
import spock.lang.Specification

class EventLogMapperSpec extends Specification {

    def "EventLogMapper: Should map Entity to DTO"(){
        given:
        EventLogDto dto = new EventLogDto()
        dto.setLog("settingName")

        when:
        def entity = EventLogMapper.INSTANCE.map(dto)

        then:
        entity.getLog() == dto.getLog()
    }

    def "EventLogMapper: Should map DTO to Entity"(){
        given:
        EventLogDao entity = EventLogDao.builder().log("email").build()

        when:
        def dto = EventLogMapper.INSTANCE.map(entity)

        then:
        dto.getLog() == entity.getLog()
    }
}
