package pl.estrix.shopsync.persist.eventlog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.EventLogMapper;
import pl.estrix.shopsync.model.EventLogDto;
import pl.estrix.shopsync.model.EventLogSearchCriteriaDto;
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao;
import pl.estrix.shopsync.persist.eventlog.repo.EventLogRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventLogCommandExecutor extends BaseCommandExecutor<EventLogDao, EventLogDto> {

    @Autowired
    protected EventLogRepository repository;

    @Override
    protected Class<EventLogDto> getDtoClass() {
        return EventLogDto.class;
    }


    private List<EventLogDto> queryResultList = new ArrayList<>();

    public ListResponseDto<EventLogDto> find(EventLogSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<EventLogDao> result = repository.find(searchCriteria, pagingCriteria);
        queryResultList.clear();
        if (!result.isEmpty()) {
            queryResultList = result
                .stream()
                .map(EventLogMapper.INSTANCE::map)
                .collect(Collectors.toList());
        }

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public EventLogDto getById(Long id){
        return EventLogMapper.INSTANCE.map(repository.getOne(id));
    }

    public EventLogDto update(EventLogDto dto) {
        return EventLogMapper.INSTANCE.map(
                repository.save(EventLogMapper.INSTANCE.map(dto)
                ));
    }

    public EventLogDto create(EventLogDto dto) {
        return EventLogMapper.INSTANCE.map(
                repository.save(EventLogMapper.INSTANCE.map(dto)
                ));
    }
}
