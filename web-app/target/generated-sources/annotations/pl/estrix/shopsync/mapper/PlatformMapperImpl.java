package pl.estrix.shopsync.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.model.PlatformDto;
import pl.estrix.shopsync.persist.platform.model.PlatformEntry;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-09T22:16:19+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class PlatformMapperImpl implements PlatformMapper {

    @Override
    public PlatformDto map(PlatformEntry source) {
        if ( source == null ) {
            return null;
        }

        PlatformDto platformDto = new PlatformDto();

        platformDto.setId( source.getId() );
        platformDto.setName( source.getName() );
        platformDto.setCode( source.getCode() );

        return platformDto;
    }

    @Override
    public PlatformEntry map(PlatformDto source) {
        if ( source == null ) {
            return null;
        }

        PlatformEntry platformEntry = new PlatformEntry();

        platformEntry.setId( source.getId() );
        platformEntry.setName( source.getName() );
        platformEntry.setCode( source.getCode() );

        return platformEntry;
    }
}
