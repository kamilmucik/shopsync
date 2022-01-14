package pl.estrix.shopsync.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

@Mapper(componentModel = "spring")
public interface VersionMapper {

    VersionMapper INSTANCE = Mappers.getMapper(VersionMapper.class);

    VersionDto map(VersionEntry source);

    VersionEntry map(VersionDto source);

    @AfterMapping
    default void afterMapping(@MappingTarget VersionDto target, VersionEntry source) {
        target.setDescription(source.getDescription().replaceAll("(\r\n|\n)", "<br />"));
    }
}
