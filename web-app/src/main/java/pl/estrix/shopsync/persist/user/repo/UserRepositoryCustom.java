package pl.estrix.shopsync.persist.user.repo;

import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.UserSearchCriteriaDto;
import pl.estrix.shopsync.persist.user.model.User;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> find(UserSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria);

    long findCount(UserSearchCriteriaDto searchCriteria);
}
