package pl.estrix.shopsync.persist.platform.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.PlatformMapper;
import pl.estrix.shopsync.model.PlatformDto;
import pl.estrix.shopsync.model.PlatformSearchCriteriaDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;
import pl.estrix.shopsync.persist.platform.repo.PlatformRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlatformCommandExecutor extends BaseCommandExecutor<PlatformEntry, PlatformDto> {

    @Autowired
    protected PlatformRepository repository;

    @Override
    protected Class<PlatformDto> getDtoClass() {
        return PlatformDto.class;
    }

    public ListResponseDto<PlatformDto> find(PlatformSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<PlatformEntry> result = repository.find(searchCriteria, pagingCriteria);
        List<PlatformDto> queryResultList = result
                .stream()
                .map(PlatformMapper.INSTANCE::map)
                .collect(Collectors.toList());

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }
}
