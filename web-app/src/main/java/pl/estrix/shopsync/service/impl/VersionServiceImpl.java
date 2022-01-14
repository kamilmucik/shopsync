package pl.estrix.shopsync.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.commons.core.domain.paging.Order;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.entity.ListResponseDto;
import pl.estrix.shopsync.commons.entity.PagingCriteria;
import pl.estrix.shopsync.commons.mock.ReplaceableComponent;
import pl.estrix.shopsync.mapper.VersionMapper;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.model.VersionSearchCriteriaDto;
import pl.estrix.shopsync.persist.packages.executor.VersionCommandExecutor;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.persist.packages.repo.VersionRepository;
import pl.estrix.shopsync.service.VersionService;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service("versionService")
@Primary
@ReplaceableComponent
public class VersionServiceImpl implements VersionService {

    private static final Comparator<VersionDto> EMPTY_COMPARATOR = (e1, e2) -> 0;

    @Autowired
    private VersionRepository versionRepository;

    @Autowired
    private VersionCommandExecutor executor;

    @Override
    public Page<VersionDto> getVersions(PagingRequest pagingRequest) {
        String orderColumn = "id";
        String orderDir = "";
        Optional<Order> order = pagingRequest.getOrder().stream().findFirst();
        if (order.isPresent()){
            orderColumn = pagingRequest.getColumns().get(order.get().getColumn()).getData();
            orderDir = order.get().getDir().name().toUpperCase();
        }

        ListResponseDto<VersionDto> versions = executor.find(
                VersionSearchCriteriaDto.builder()
                        .platform(pagingRequest.getPlatformCode())
                        .search(pagingRequest.getSearch().getValue())
                        .build(),
                PagingCriteria.builder()
                        .start(pagingRequest.getStart())
                        .limit(pagingRequest.getLength())
                        .orderColumn(orderColumn)
                        .orderDir(orderDir)
                        .build());
        return getPage(versions.getData(), pagingRequest,versions.getTotalCount());
    }

    @Override
    public VersionDto getById(Long id) {
        VersionEntry entry = versionRepository.getOne(id);

        return VersionMapper.INSTANCE.map(entry);
    }

    @Override
    public void deleteById(Long id) {
        versionRepository.deleteById(id);
    }

    @Override
    public VersionDto save(VersionDto product) {
        VersionEntry entry = null;
        if (product.getId() == null){
            entry = new VersionEntry();
        } else {
            entry = versionRepository.getOne(product.getId());
        }
//        entry.setDate(new Date());
        entry.setDescription(product.getDescription());
        entry.setEnviroment(product.getEnviroment());
        entry.setInstaller(product.getInstaller());
        entry.setPlatform(product.getPlatform());
        entry.setNumber(product.getNumber());
        versionRepository.save(entry);
        return product;
    }

    private Page<VersionDto> getPage(List<VersionDto> employees, PagingRequest pagingRequest, Integer total) {
        Page<VersionDto> page = new Page<>(employees);
        page.setRecordsFiltered((int) total);
        page.setRecordsTotal((int) total);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

}
