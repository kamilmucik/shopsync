package pl.estrix.shopsync.mapper

import pl.estrix.shopsync.model.SettingDto
import pl.estrix.shopsync.persist.setting.model.AppSetting
import spock.lang.Specification

class SettingMapperSpec extends Specification {

    def "SettingMapper: Should map Entity to DTO"(){
        given:
        SettingDto dto = new SettingDto()
        dto.setName("settingName")

        when:
        def entity = SettingMapper.INSTANCE.map(dto)

        then:
        entity.getName() == dto.getName()
    }

    def "SettingMapper: Should map DTO to Entity"(){
        given:
        AppSetting entity = AppSetting.builder().name("email").build()

        when:
        def dto = SettingMapper.INSTANCE.map(entity)

        then:
        dto.getName() == entity.getName()
    }
}
