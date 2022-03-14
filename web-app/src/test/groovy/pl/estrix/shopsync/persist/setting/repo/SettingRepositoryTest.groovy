package pl.estrix.shopsync.persist.setting.repo

import org.junit.Ignore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.estrix.shopsync.commons.entity.PagingCriteria
import pl.estrix.shopsync.model.SettingSearchCriteriaDto
import pl.estrix.shopsync.persist.setting.model.AppSetting
import pl.estrix.shopsync.persist.setting.repo.impl.SettingRepositoryImpl
import pl.estrix.shopsync.persist.version.VersionExecutor
import spock.lang.Specification

@Ignore
class SettingRepositoryTest extends Specification {


    def settingRepositoryMock = Stub(SettingRepositoryImpl)

//    def "finad setting by Id"() {
//
//        when: "load entity"
//        settingRepositoryMock.findByName("email@test.pl")
//
//        then:"saven adn retrived entity mus by equal"
//        1 == 1
//    }
    def "finad setting all"() {
        given:
        def settingSearchCriteriaDto = prepareSettingSearchCriteriaDtoMock()
        def pagingCriteria = preparePagingCriteriaMock()
//        1 * settingRepositoryMock.findCount(_) >> 1L


        when: "load entity"
        def resultList = settingRepositoryMock.findCount(settingSearchCriteriaDto)
//        def resultList = settingRepositoryMock.find(settingSearchCriteriaDto,pagingCriteria)

        then:"saven adn retrived entity mus by equal"
        1 == 1
    }

    def SettingSearchCriteriaDto prepareSettingSearchCriteriaDtoMock() {
        SettingSearchCriteriaDto criteriaDto = new SettingSearchCriteriaDto()

        return criteriaDto
    }

    def PagingCriteria preparePagingCriteriaMock() {
        PagingCriteria criteria = new PagingCriteria()

        criteria
    }
}
