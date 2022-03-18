package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.service.VersionService;

/**
 * User interfaces for
 * @since 0.0.1
 * @author kamilmucik
 */
@RestController
@AllArgsConstructor
public class VersionRestController {

    private final VersionService versionService;

    private final BuildProperties buildProperties;

    /**
     *
     */
    @GetMapping("/version")
    public VersionDto getVersion(){
        return VersionDto.builder().version(buildProperties.getVersion()).build();
//        return this.versionService.getVersion("0.0.1");
    }
}
