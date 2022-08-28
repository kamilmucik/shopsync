package pl.estrix.shopsync.mapper

import pl.estrix.shopsync.model.WarehouseDto
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao
import spock.lang.Specification

class WarehouseMapperSpec extends Specification {

    def "SettingMapper: Should map Entity to DTO"(){
        given:
        WarehouseDto dto = new WarehouseDto()
        dto.setName("warehouseName")
        dto.setLastUpdate("202208262005")
        dto.setApiUrl("api-url")
        dto.setUrl("url")

        when:
        def entity = WarehouseMapper.INSTANCE.map(dto)

        then:
        entity.getName() == dto.getName()
        entity.getLastUpdate() == dto.getLastUpdate()
        entity.getUrl() == dto.getUrl()
        entity.getApiUrl() == dto.getApiUrl()
    }

    def "SettingMapper: Should map DTO to Entity"(){
        given:
        WarehouseDao entity = WarehouseDao.builder()
                .name("name")
                .lastUpdate("202208262005")
                .url("url")
                .apiUrl("api-url")
                .build()

        when:
        def dto = WarehouseMapper.INSTANCE.map(entity)

        then:
        dto.getName() == entity.getName()
        dto.getLastUpdate() == entity.getLastUpdate()
        dto.getUrl() == entity.getUrl()
        dto.getApiUrl() == entity.getApiUrl()
    }
}
