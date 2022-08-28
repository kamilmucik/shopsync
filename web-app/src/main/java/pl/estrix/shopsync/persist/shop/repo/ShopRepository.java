package pl.estrix.shopsync.persist.shop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.estrix.shopsync.persist.shop.model.ShopDao;

public interface ShopRepository extends ShopRepositoryCustom,
        JpaRepository<ShopDao, Long>,
        QuerydslPredicateExecutor<ShopDao> {

    ShopDao findByName(String name);
}
