package pl.estrix.shopsync.persist.packages.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

import java.util.List;

@Repository
public interface VersionRepository extends VersionRepositoryCustom,
        JpaRepository<VersionEntry, Long>,
        QuerydslPredicateExecutor<VersionEntry> {

    @Query("SELECT v FROM VersionEntry v WHERE v.platform LIKE :platform")
    List<VersionEntry> findByCode(@Param("platform") String platform);

}
