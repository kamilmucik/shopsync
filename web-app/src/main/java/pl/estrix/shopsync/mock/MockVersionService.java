package pl.estrix.shopsync.mock;

import org.springframework.context.annotation.Bean;
import pl.estrix.shopsync.commons.mock.BaseMockService;
import pl.estrix.shopsync.commons.mock.ReplacingMockComponent;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.service.VersionService;
import pl.estrix.shopsync.service.impl.VersionServiceImpl;

@ReplacingMockComponent(clazz = VersionServiceImpl.class)
public class MockVersionService extends BaseMockService {

    @Bean(name = "mockVersionService")
    VersionService versionService(){
        return version -> VersionDto.builder().version("0.0.1").build();
    }
}
