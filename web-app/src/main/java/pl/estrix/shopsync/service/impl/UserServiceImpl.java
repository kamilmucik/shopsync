package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.model.UserPasswordDto;
import pl.estrix.shopsync.model.UserSearchCriteriaDto;
import pl.estrix.shopsync.persist.user.executor.UserCommandExecutor;
import pl.estrix.shopsync.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

//    @Autowired
    private final UserCommandExecutor executor;

//    @Autowired
    private final PasswordEncoder standardPasswordEncoder;

    @Override
    public Page<UserDto> getUsers(PagingRequest pagingRequest) {
        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }

        ListResponseDto<UserDto> users = executor.find(
                UserSearchCriteriaDto.builder()
                        .search(pagingRequest.getSearch().getValue())
                        .build(),
                PagingCriteria.builder()
                        .start(pagingRequest.getStart())
                        .limit(pagingRequest.getLength())
                        .orderColumn(orderColumn)
                        .orderDir(orderDir)
                        .build());
        return getPage(users.getData(), pagingRequest,users.getTotalCount());
    }

    @Override
    public UserDto getById(Long id) {
        return executor.getById(id);
    }

    @Override
    public UserDto getByLogin(String login) {
        return executor.getByEmail(UserDto.builder().email(login).build());
    }

    @Override
    public void deleteById(Long id) {
        executor.deleteById(id);
    }

    @Override
    public UserDto save(UserDto userDto) {
        UserDto temp = null;
        if (userDto.getId() != null){
            userDto.setPassword(createPasswordHash(userDto.getPassword()));
            temp = executor.update(userDto);
        } else {
            userDto.setPassword(createPasswordHash(userDto.getPassword()));
            userDto.setLocked(false);
            userDto.setRole("ROLE_USER");
            userDto.setEnabled(true);
            temp = executor.create(userDto);
        }
        return temp;
    }

    @Override
    public String createPasswordHash(String password) {
        return standardPasswordEncoder.encode(password);
    }

    private Page<UserDto> getPage(List<UserDto> employees, PagingRequest pagingRequest, Integer total) {
        Page<UserDto> page = new Page<>(employees);
        page.setRecordsFiltered(total);
        page.setRecordsTotal(total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }
}
