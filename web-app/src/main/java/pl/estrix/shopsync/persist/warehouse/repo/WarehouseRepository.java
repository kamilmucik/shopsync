package pl.estrix.shopsync.persist.warehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.estrix.shopsync.persist.warehouse.model.WarehouseDao;

public interface WarehouseRepository extends WarehouseRepositoryCustom,
        JpaRepository<WarehouseDao, Long>,
        QuerydslPredicateExecutor<WarehouseDao> {

    WarehouseDao findByName(String name);
}
