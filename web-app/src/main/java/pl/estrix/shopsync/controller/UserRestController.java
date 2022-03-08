package pl.estrix.shopsync.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.estrix.shopsync.commons.core.domain.paging.Page;
import pl.estrix.shopsync.commons.core.domain.paging.PagingRequest;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.service.UserService;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/user")
public class UserRestController {

    private final UserService userService;

    @PostMapping(path="/list")
    public Page<UserDto> list(@RequestBody PagingRequest pagingRequest) {
        return userService.getUsers(pagingRequest);
    }
}