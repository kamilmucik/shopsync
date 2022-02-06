package pl.estrix.shopsync.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.service.UserService;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(path="/list", method=RequestMethod.POST)
    public Page<UserDto> list(@RequestBody PagingRequest pagingRequest) {
        return userService.getUsers(pagingRequest);
    }


}