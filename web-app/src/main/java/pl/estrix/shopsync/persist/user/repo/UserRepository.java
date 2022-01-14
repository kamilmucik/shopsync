package pl.estrix.shopsync.persist.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.estrix.shopsync.persist.user.model.User;

public interface UserRepository extends UserRepositoryCustom,
        JpaRepository<User, Long>,
        QuerydslPredicateExecutor<User> {

    User findOneByEmail(String email);
}
