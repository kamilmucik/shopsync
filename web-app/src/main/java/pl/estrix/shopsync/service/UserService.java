package pl.estrix.shopsync.service;

import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.UserDto;

public interface UserService {

    Page<UserDto> getUsers(PagingRequest pagingRequest);

    UserDto getById(Long id);
    UserDto getByLogin(String login);

    void deleteById(Long id);

    UserDto save(UserDto product);

    String createPasswordHash(String password);

}
