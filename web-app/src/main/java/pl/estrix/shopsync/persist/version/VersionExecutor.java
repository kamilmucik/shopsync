package pl.estrix.shopsync.persist.version;

import org.springframework.stereotype.Component;
import pl.estrix.shopsync.model.VersionDto;

import java.util.HashMap;
import java.util.Map;

@Component
public class VersionExecutor {

    private Map<String, VersionDto> versionDtoMap;

    public VersionExecutor() {
        this.versionDtoMap = new HashMap<>();
    }

    public VersionDto findOneByVersion(String version) {
        return this.versionDtoMap.get(version);
    }

    /**
     * {@inheritDoc}
     */
    public void add(VersionDto versionDto) {
        this.versionDtoMap.put(versionDto.getVersion(), versionDto);
    }
}
