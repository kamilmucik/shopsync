package pl.estrix.shopsync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.EventLogDto;
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao;

@Mapper(componentModel = "spring")
public interface EventLogMapper {

    EventLogMapper INSTANCE = Mappers.getMapper(EventLogMapper.class);

    EventLogDto map(EventLogDao source);

    EventLogDao map(EventLogDto source);

}
