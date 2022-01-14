package pl.estrix.shopsync.persist.platform.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.persist.packages.repo.VersionRepositoryCustom;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;

@Repository
public interface PlatformRepository extends PlatformRepositoryCustom,
        JpaRepository<PlatformEntry, Long>,
        QuerydslPredicateExecutor<PlatformEntry> {
}
