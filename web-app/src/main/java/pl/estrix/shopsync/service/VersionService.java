package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

public interface VersionService {

    Page<VersionDto> getVersions(PagingRequest pagingRequest);

    VersionDto getById(Long id);

    void deleteById(Long id);

    VersionDto save(VersionDto product);
}
