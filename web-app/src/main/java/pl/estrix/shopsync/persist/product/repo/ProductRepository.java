package pl.estrix.shopsync.persist.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.estrix.shopsync.persist.product.model.ProductDao;

public interface ProductRepository extends ProductRepositoryCustom,
        JpaRepository<ProductDao, Long>,
        QuerydslPredicateExecutor<ProductDao> {

    ProductDao findByName(String name);
}
