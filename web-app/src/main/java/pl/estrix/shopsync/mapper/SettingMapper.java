package pl.estrix.shopsync.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    SettingMapper INSTANCE = Mappers.getMapper(SettingMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "value", source = "value")
    })
    SettingDto map(AppSetting source);

    @AfterMapping
    default void afterMapping(@MappingTarget SettingDto target, AppSetting source) {
//        target.setIdMap(source.getId().toString());
    }

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "code", source = "code"),
            @Mapping(target = "value", source = "value")
    })
    AppSetting map(SettingDto source);
}
