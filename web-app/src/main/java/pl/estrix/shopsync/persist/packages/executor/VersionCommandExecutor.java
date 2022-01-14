package pl.estrix.shopsync.persist.packages.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.VersionMapper;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.model.VersionSearchCriteriaDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.persist.packages.repo.VersionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VersionCommandExecutor extends BaseCommandExecutor<VersionEntry, VersionDto> {

    @Autowired
    protected VersionRepository repository;

    @Override
    protected Class<VersionDto> getDtoClass() {
        return VersionDto.class;
    }

    public ListResponseDto<VersionDto> find(VersionSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<VersionEntry> result = repository.find(searchCriteria, pagingCriteria);
        List<VersionDto> queryResultList = result
                .stream()
                .map(VersionMapper.INSTANCE::map)
                .collect(Collectors.toList());

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

}
