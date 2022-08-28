package pl.estrix.shopsync.persist.shop

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import pl.estrix.shopsync.commons.entity.PagingCriteria
import pl.estrix.shopsync.model.ShopSearchCriteriaDto
import pl.estrix.shopsync.persist.shop.model.ShopDao
import pl.estrix.shopsync.persist.shop.repo.ShopRepository
import spock.lang.Specification

@DataJpaTest
class ShopRepositorySpecIT extends Specification{

    @Autowired
    private ShopRepository repository;

    def "find setting by Id"() {
        given:
        def dao = new ShopDao()
        dao.setId(3L)
        dao.setLastUpdate("20220826203500")
        dao.setName("shopName")
        dao.setApiUrl("api-url")
        dao.setUrl("url")
        def entity = repository.save(dao)

        when: "load entity"
        def daoDB = repository.findByName("shopName")

        then:"saven adn retrived entity mus by equal"
        dao.id == entity.id
        dao.id == daoDB.id
    }

    def "should find all setting records"(){
        given:
            def searchCriteria = new ShopSearchCriteriaDto()
            def pagingCriteria = new PagingCriteria()
            pagingCriteria.setStart(0)
            pagingCriteria.setLimit(10)
            pagingCriteria.setOrderColumn("id")
            pagingCriteria.setOrderDir("ASC")

        when:
            def resultList = repository.find(searchCriteria,pagingCriteria)
            def resultCnt = repository.findCount(searchCriteria)

        then:
            !resultList.isEmpty()
            resultList.size() == resultCnt
    }
}
