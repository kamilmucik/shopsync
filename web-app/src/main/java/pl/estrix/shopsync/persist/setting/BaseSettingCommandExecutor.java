package pl.estrix.shopsync.persist.setting;

import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

@Component
public class BaseSettingCommandExecutor extends BaseCommandExecutor<AppSetting, SettingDto> {

    @Override
    protected Class<SettingDto> getDtoClass() {
        return SettingDto.class;
    }
}
