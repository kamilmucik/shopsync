package pl.estrix.shopsync.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.mock.ReplaceableComponent;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.version.VersionExecutor;
import pl.estrix.shopsync.service.VersionService;

//@Slf4j
@Service("versionService")
@Primary
@ReplaceableComponent
public class VersionServiceImpl implements VersionService {

    private final VersionExecutor versionExecutor;

    public VersionServiceImpl(VersionExecutor versionExecutor) {
        this.versionExecutor = versionExecutor;
    }

    @Override
    public VersionDto getVersion(String version) {
        return versionExecutor.findOneByVersion(version);
    }
}
