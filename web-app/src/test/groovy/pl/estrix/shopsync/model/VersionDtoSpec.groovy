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

    def "VersionDto: should test allArgsConstructor"(){
        when:
        def version = new VersionDto(name)

        then:
        version.getVersion().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "VersionDto: should test Builder"(){
        when:
        def version = VersionDto.builder().version(name).build()

        then:
        version.getVersion().equals(expected)

        where:
        name       | expected
        "Mercury"  | "Mercury"
    }

    def "should throw an IllegalArgument exception if invalid name given"() {
        when:
        versionDto.setVersion(null)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == "Planet name given was invalid"
    }

}
