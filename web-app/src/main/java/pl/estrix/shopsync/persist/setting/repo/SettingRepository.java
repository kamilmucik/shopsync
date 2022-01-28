package pl.estrix.shopsync.persist.setting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.estrix.shopsync.persist.setting.model.AppSetting;

@Repository
public interface SettingRepository extends JpaRepository<AppSetting, Long> {

    AppSetting findByName(String name);
}
