package pl.estrix.shopsync.service;

import pl.estrix.shopsync.model.VersionDto;

public interface VersionService {

    VersionDto getVersion(String version);
}
