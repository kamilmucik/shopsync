package pl.estrix.shopsync.persist.setting

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.estrix.shopsync.persist.setting.model.AppSetting
import pl.estrix.shopsync.persist.setting.repo.SettingRepository
import spock.lang.Specification

@DataJpaTest
class SettingRepositorySpecIT extends Specification{

    @Autowired
    private SettingRepository settingRepository;

    def appSetting = new AppSetting(1L,"name", "code", "value", "type")

    def "finad setting by Id"() {
        def appSettingEntity = settingRepository.save(appSetting)

        when: "load entity"
        def appSettingDb = settingRepository.findByName("name")

        then:"saven adn retrived entity mus by equal"
        appSettingEntity.id == appSettingDb.id
    }
}
