package pl.estrix.shopsync.service

import pl.estrix.shopsync.persist.version.VersionExecutor
import pl.estrix.shopsync.service.impl.VersionServiceImpl
import spock.lang.Specification

/**
 * Unit test for Version Service
 */
class VersionServiceSpec extends Specification{

    def versionExecutorMock = Mock(VersionExecutor)

    def versionService = new VersionServiceImpl(versionExecutorMock)

    def "should use the executor to fetch one Version by name"() {
        when:
        versionService.getVersion("0.0.1")

        then:
        1 * versionExecutorMock.findOneByVersion("0.0.1")
    }
}
