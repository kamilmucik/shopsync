package pl.estrix.shopsync.model

import spock.lang.Specification


class VersionDtoSpec extends Specification{

    VersionDto versionDto = new VersionDto()

    def "should return planet's name"() {
        when:
        versionDto.setVersion(name)

        then:
        versionDto.getVersion().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
        "LV-426"   | "LV-426"
        "WASP-12b" | "WASP-12b"
    }

    def "should throw an IllegalArgument exception if invalid name given"() {
        when:
        versionDto.setVersion(null)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == "Planet name given was invalid"
    }

}
