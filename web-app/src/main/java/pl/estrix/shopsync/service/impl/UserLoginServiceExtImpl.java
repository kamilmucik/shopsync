package pl.estrix.shopsync.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.estrix.shopsync.model.UserDto;
import pl.estrix.shopsync.persist.user.executor.UserCommandExecutor;
import pl.estrix.shopsync.persist.user.model.Role;
import pl.estrix.shopsync.service.UserLoginServiceExt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class UserLoginServiceExtImpl implements UserLoginServiceExt {

    @Autowired
    private UserCommandExecutor executor;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = executor.getByEmail(UserDto.builder().email(email).build());

        if (user == null)
            throw new UsernameNotFoundException("User " + email + " not found");

        List<Role> roles = new ArrayList<>();
        roles.add(Role.valueOf(user.getRole()));
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        boolean enabled = user.isEnabled();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = !user.isLocked();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

    }
}
