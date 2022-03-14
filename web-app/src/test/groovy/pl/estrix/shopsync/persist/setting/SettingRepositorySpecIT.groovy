package pl.estrix.shopsync.persist.setting


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.estrix.shopsync.commons.entity.PagingCriteria
import pl.estrix.shopsync.model.SettingSearchCriteriaDto
import pl.estrix.shopsync.persist.setting.model.AppSetting
import pl.estrix.shopsync.persist.setting.repo.SettingRepository
import spock.lang.Specification

@DataJpaTest
class SettingRepositorySpecIT extends Specification{

    @Autowired
    private SettingRepository settingRepository;

    def "find setting by Id"() {
        given:
        def appSetting = new AppSetting()
        appSetting.setId(3L)
        appSetting.setLastUpdate("")
        appSetting.setName("sampleName")
        appSetting.setCode("sampleCOde")
        appSetting.setValue("sampleValue")
        appSetting.setType("sampleType")
        def appSettingEntity = settingRepository.save(appSetting)

        when: "load entity"
        def appSettingDb = settingRepository.findByName("sampleName")

        then:"saven adn retrived entity mus by equal"
        appSettingEntity.id == appSettingDb.id
    }

    def "should find all setting records"(){
        given:
            def searchCriteria = new SettingSearchCriteriaDto()
            def pagingCriteria = new PagingCriteria()
            pagingCriteria.setStart(0)
            pagingCriteria.setLimit(5)
            pagingCriteria.setOrderColumn("id")
            pagingCriteria.setOrderDir("ASC")

        when:
            def resultList = settingRepository.find(searchCriteria,pagingCriteria)
            def resultCnt = settingRepository.findCount(searchCriteria)

        then:
            !resultList.isEmpty()
            resultList.size() == resultCnt
    }
}
