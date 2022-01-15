package pl.estrix.shopsync.controller;

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
public class VersionRestController {

    private final VersionService versionService;

    public VersionRestController(VersionService service){
        this.versionService = service;
    }

    /**
     *
     */
    @GetMapping("/version")
    public VersionDto getVersion(){
        return this.versionService.getVersion("0.0.1");
    }
}
