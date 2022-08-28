package pl.estrix.shopsync.mapper

import pl.estrix.shopsync.model.ShopDto
import pl.estrix.shopsync.persist.shop.model.ShopDao
import spock.lang.Specification

class ShopMapperSpec extends Specification {

    def "ShopMapper: Should map Entity to DTO"(){
        given:
        ShopDto dto = new ShopDto()
        dto.setName("shopName")
        dto.setLastUpdate("202208262005")
        dto.setApiUrl("api-url")
        dto.setUrl("url")

        when:
        def entity = ShopMapper.INSTANCE.map(dto)

        then:
        entity.getName() == dto.getName()
        entity.getLastUpdate() == dto.getLastUpdate()
        entity.getUrl() == dto.getUrl()
        entity.getApiUrl() == dto.getApiUrl()
    }

    def "ShopMapper: Should map DTO to Entity"(){
        given:
        ShopDao entity = ShopDao.builder()
                .name("name")
                .lastUpdate("202208262005")
                .url("url")
                .apiUrl("api-url")
                .build()

        when:
        def dto = ShopMapper.INSTANCE.map(entity)

        then:
        dto.getName() == entity.getName()
        dto.getLastUpdate() == entity.getLastUpdate()
        dto.getUrl() == entity.getUrl()
        dto.getApiUrl() == entity.getApiUrl()
    }
}
