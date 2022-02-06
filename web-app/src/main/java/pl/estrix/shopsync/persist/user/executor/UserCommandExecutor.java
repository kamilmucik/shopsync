package pl.estrix.shopsync.persist.user.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.UserMapper;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.model.UserSearchCriteriaDto;
import pl.estrix.shopsync.persist.user.model.User;
import pl.estrix.shopsync.persist.user.repo.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCommandExecutor extends BaseCommandExecutor<User, UserDto> {

    @Autowired
    protected UserRepository repository;

    @Override
    protected Class<UserDto> getDtoClass() {
        return UserDto.class;
    }

    public ListResponseDto<UserDto> find(UserSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<User> result = repository.find(searchCriteria, pagingCriteria);
        List<UserDto> queryResultList = result
                .stream()
                .map(UserMapper.INSTANCE::map)
                .collect(Collectors.toList());

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public UserDto getById(Long id){
        return UserMapper.INSTANCE.map(repository.getOne(id));
    }

    public UserDto update(UserDto dto) {
        return UserMapper.INSTANCE.map(
                repository.save(UserMapper.INSTANCE.map(dto)
                ));
    }

    public UserDto create(UserDto storeDto) {
        return UserMapper.INSTANCE.map(
                repository.save(UserMapper.INSTANCE.map(storeDto)
                ));
    }

    public UserDto getByEmail(UserDto userDto){
        return UserMapper.INSTANCE.map(repository.findOneByEmail(userDto.getEmail()));
    }
}
