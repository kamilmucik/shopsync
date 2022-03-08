package pl.estrix.shopsync.persist.setting.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.SettingSearchCriteriaDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

import java.util.List;

public interface SettingRepositoryCustom {

    List<AppSetting> find(SettingSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(SettingSearchCriteriaDto searchCriteria);
}
