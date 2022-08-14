package pl.estrix.shopsync.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
public class UserLoginServiceExtImpl implements UserLoginServiceExt {

    private final UserCommandExecutor executor;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDto user = executor.getByEmail(UserDto.builder().email(email).build());

        if (user == null)
            throw new UsernameNotFoundException("User " + email + " not found");

        List<Role> roles = new ArrayList<>();
        roles.add(Role.valueOf(user.getRole()));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }

        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        boolean enabled = user.isEnabled();
        boolean accountNonLocked = !user.isLocked();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), enabled, true, true, accountNonLocked, authorities);
    }
}
