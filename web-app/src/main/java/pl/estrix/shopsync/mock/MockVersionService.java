package pl.estrix.shopsync.mock;

import org.springframework.context.annotation.Bean;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.commons.mock.BaseMockService;
import pl.estrix.shopsync.commons.mock.ReplacingMockComponent;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.service.VersionService;
import pl.estrix.shopsync.service.impl.VersionServiceImpl;

import java.util.Arrays;
import java.util.List;

@ReplacingMockComponent(clazz = VersionServiceImpl.class)
public class MockVersionService extends BaseMockService {

    @Bean(name = "mockVersionService")
    VersionService versionService(){
        return new VersionService(){

            @Override
            public Page<VersionDto> getVersions(PagingRequest pagingRequest) {
                VersionDto entry1 = VersionDto.builder().number("1").build();
                VersionDto entry2 = VersionDto.builder().number("2").build();

                List<VersionDto> filtered = Arrays.asList(
                        entry1,entry2
                );
                return new Page<>(filtered);
            }

            @Override
            public VersionDto getById(Long id) {
                return null;
            }

            @Override
            public void deleteById(Long id) {

            }

            @Override
            public VersionDto save(VersionDto product) {
                return product;
            }
        };
    }
}
