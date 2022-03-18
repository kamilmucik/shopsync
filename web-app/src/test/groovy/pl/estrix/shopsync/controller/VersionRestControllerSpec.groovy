package pl.estrix.shopsync.controller

import org.junit.Ignore
import pl.estrix.shopsync.service.impl.VersionServiceImpl
import spock.lang.Specification

/**
 * Unit test for VersionRestController
 */
@Ignore
class VersionRestControllerSpec extends Specification{

    def versionServiceMock = Mock(VersionServiceImpl)
    def versionController = new VersionRestController(versionServiceMock)

    def "should ask the VersionService for version information"() {
        when:
        versionController.getVersion()

        then:
        1 * versionServiceMock.getVersion("0.0.1")
    }
}
