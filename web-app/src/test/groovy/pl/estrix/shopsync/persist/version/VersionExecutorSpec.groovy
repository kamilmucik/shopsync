package pl.estrix.shopsync.persist.version

import pl.estrix.shopsync.model.VersionDto
import spock.lang.Specification

/**
 * Unit Test Version Executor.
 */
class VersionExecutorSpec extends Specification{

    VersionExecutor versionExecutor = new VersionExecutor();

    def "should return an instance of VersionDto with 0.0.1 details"() {
        given:
        def ver001 = Stub(VersionDto)
        ver001.getVersion() >> "0.0.1"
        versionExecutor.add(ver001)

        when:
        def ver = versionExecutor.findOneByVersion("0.0.1")

        then:
        ver.getVersion() == "0.0.1"
    }
}
