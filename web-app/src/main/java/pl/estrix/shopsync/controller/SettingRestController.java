package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.service.SettingService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/setting")
public class SettingRestController {

    private final SettingService settingService;

    @PostMapping(path="/list")
    public Page<SettingDto> list(@RequestBody PagingRequest pagingRequest) {
        return settingService.getList(pagingRequest);
    }
}
