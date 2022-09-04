package pl.estrix.shopsync.model

import spock.lang.Specification

import java.time.LocalDateTime

class ProductDtoSpec extends Specification {

    ProductDto dto = new ProductDto()

    def "ProductDto: should return log"() {
        when:
        dto.setLastUpdated(LocalDateTime.now())
        dto.setName(name)
        dto.setAmount(name)
        dto.setDescription(name)

        then:
        dto.getName().equals(expected)

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }

    def "ProductDto: should test toString"() {
        when:
        dto.setName("11")

        then:
        !dto.toString().isEmpty()
    }

    def "ProductDto: should test equal"() {
        when:
        dto.setName(name)
        def dto2 = new ProductDto()
        dto2.setName(name)

        then:
        dto.equals(dto2)
        dto.hashCode() instanceof Integer

        where:
        name       | expected
        "admin"    | "admin"
        "user"     | "user"
        "operator" | "operator"
    }


    def "ProductDto: should test equal: error 1"() {
        when:
        dto.setName("name")
        def dto2 = new ProductDto()

        then:
        !dto.equals(dto2)
    }

    def "ProductDto: should test equal: same object"() {
        when:
        dto.setName("name")

        then:
        dto.equals(dto)
    }

    def "ProductDto: should test equal: error null object"() {
        when:
        dto.setName("name")

        then:
        !dto.equals(null)
    }
}
