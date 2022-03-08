package pl.estrix.shopsync.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    SettingMapper INSTANCE = Mappers.getMapper(SettingMapper.class);

    SettingDto map(AppSetting source);

    AppSetting map(SettingDto source);
}
