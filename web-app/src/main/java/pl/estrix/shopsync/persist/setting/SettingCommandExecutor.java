package pl.estrix.shopsync.persist.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.commons.entity.BaseCommandExecutor;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.mapper.SettingMapper;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.model.SettingSearchCriteriaDto;
import pl.estrix.shopsync.persist.setting.model.AppSetting;
import pl.estrix.shopsync.persist.setting.repo.SettingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SettingCommandExecutor  extends BaseCommandExecutor<AppSetting, SettingDto> {

    @Autowired
    protected SettingRepository repository;

    @Override
    protected Class<SettingDto> getDtoClass() {
        return SettingDto.class;
    }


    private List<SettingDto> queryResultList = new ArrayList<>();

    public ListResponseDto<SettingDto> find(SettingSearchCriteriaDto searchCriteria, PagingCriteria pagingCriteria) {
        List<AppSetting> result = repository.find(searchCriteria, pagingCriteria);
        queryResultList.clear();
        if (!result.isEmpty()) {
            queryResultList = result
                .stream()
                .map(SettingMapper.INSTANCE::map)
                .collect(Collectors.toList());
        }

        return createListResponseDto(pagingCriteria, () -> queryResultList, () -> (int) repository.findCount(searchCriteria));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public SettingDto getById(Long id){
        return SettingMapper.INSTANCE.map(repository.getOne(id));
    }

    public SettingDto update(SettingDto dto) {
        return SettingMapper.INSTANCE.map(
                repository.save(SettingMapper.INSTANCE.map(dto)
                ));
    }

    public SettingDto create(SettingDto storeDto) {
        return SettingMapper.INSTANCE.map(
                repository.save(SettingMapper.INSTANCE.map(storeDto)
                ));
    }
}
