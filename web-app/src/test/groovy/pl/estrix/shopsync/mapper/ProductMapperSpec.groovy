package pl.estrix.shopsync.mapper

import pl.estrix.shopsync.model.ProductDto
import pl.estrix.shopsync.persist.product.model.ProductDao
import spock.lang.Specification

class ProductMapperSpec extends Specification {

    def "ProductMapper: Should map Entity to DTO"(){
        given:
        ProductDto dto = new ProductDto()
        dto.setName("settingName")

        when:
        def entity = ProductMapper.INSTANCE.map(dto)

        then:
        entity.getName() == dto.getName()
    }

    def "ProductMapper: Should map DTO to Entity"(){
        given:
        ProductDao entity = ProductDao.builder().name("email").build()

        when:
        def dto = ProductMapper.INSTANCE.map(entity)

        then:
        dto.getName() == entity.getName()
    }
}
