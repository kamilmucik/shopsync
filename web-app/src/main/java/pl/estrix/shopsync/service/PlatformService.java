package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.PlatformDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;

import java.util.List;

public interface PlatformService {

    List<PlatformDto> getAllPlatforms();

    Page<PlatformDto> getAllPlatforms(PagingRequest pagingRequest);

    PlatformEntry getById(Long id);

}
