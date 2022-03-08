package pl.estrix.shopsync.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.SettingDto;
import pl.estrix.shopsync.service.SettingService;

@Slf4j
@RestController
@RequestMapping(value = "/setting")
public class SettingRestController {

    @Autowired
    private SettingService settingService;

    @RequestMapping(path="/list", method= RequestMethod.POST)
    public Page<SettingDto> list(@RequestBody PagingRequest pagingRequest) {
        return settingService.getList(pagingRequest);
    }
}
