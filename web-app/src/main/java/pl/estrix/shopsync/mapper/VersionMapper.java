//package pl.estrix.shopsync.mapper;
//
//import org.mapstruct.*;
//import org.mapstruct.factory.Mappers;
//import pl.bpsa.packages.model.VersionDto;
//import pl.bpsa.packages.persist.packages.model.VersionEntry;
//
//@Mapper(componentModel = "spring")
//public interface VersionMapper {
//
//    VersionMapper INSTANCE = Mappers.getMapper(VersionMapper.class);
//
//    VersionDto map(VersionEntry source);
//
//    VersionEntry map(VersionDto source);
//
//    @AfterMapping
//    default void afterMapping(@MappingTarget VersionDto target, VersionEntry source) {
//        target.setDescription(source.getDescription().replaceAll("(\r\n|\n)", "<br />"));
//    }
//}
