package pl.estrix.shopsync.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-09T22:16:19+0100",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
@Component
public class VersionMapperImpl implements VersionMapper {

    @Override
    public VersionDto map(VersionEntry source) {
        if ( source == null ) {
            return null;
        }

        VersionDto versionDto = new VersionDto();

        versionDto.setId( source.getId() );
        versionDto.setNumber( source.getNumber() );
        versionDto.setEnviroment( source.getEnviroment() );
        versionDto.setInstaller( source.getInstaller() );
        versionDto.setDescription( source.getDescription() );
        versionDto.setPlatform( source.getPlatform() );

        afterMapping( versionDto, source );

        return versionDto;
    }

    @Override
    public VersionEntry map(VersionDto source) {
        if ( source == null ) {
            return null;
        }

        VersionEntry versionEntry = new VersionEntry();

        versionEntry.setId( source.getId() );
        versionEntry.setNumber( source.getNumber() );
        versionEntry.setEnviroment( source.getEnviroment() );
        versionEntry.setInstaller( source.getInstaller() );
        versionEntry.setDescription( source.getDescription() );
        versionEntry.setPlatform( source.getPlatform() );

        return versionEntry;
    }
}
