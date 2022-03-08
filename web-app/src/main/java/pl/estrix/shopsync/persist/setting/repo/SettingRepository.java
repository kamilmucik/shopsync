package pl.estrix.shopsync.persist.setting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.estrix.shopsync.persist.setting.model.AppSetting;
import pl.estrix.shopsync.persist.user.model.User;

public interface SettingRepository extends SettingRepositoryCustom,
        JpaRepository<AppSetting, Long>,
        QuerydslPredicateExecutor<AppSetting> {

    AppSetting findByName(String name);
}
