package pl.estrix.shopsync.persist.eventlog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.estrix.shopsync.persist.eventlog.model.EventLogDao;

public interface EventLogRepository extends EventLogRepositoryCustom,
        JpaRepository<EventLogDao, Long>,
        QuerydslPredicateExecutor<EventLogDao> {

    EventLogDao findByLog(String log);
}
