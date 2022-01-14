package pl.estrix.shopsync.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.model.VersionDto;
import pl.estrix.shopsync.persist.packages.model.VersionEntry;
import pl.estrix.shopsync.service.PlatformService;
import pl.estrix.shopsync.service.UserService;
import pl.estrix.shopsync.service.VersionService;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private PlatformService platformService;

    @RequestMapping(path="/list", method=RequestMethod.POST)
    public Page<UserDto> list(@RequestBody PagingRequest pagingRequest) {
        return userService.getUsers(pagingRequest);
    }


}