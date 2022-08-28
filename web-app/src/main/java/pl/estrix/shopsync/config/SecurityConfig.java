package pl.estrix.shopsync.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import pl.estrix.shopsync.persist.user.executor.UserCommandExecutor;
import pl.estrix.shopsync.persist.user.repo.UserRepository;
import pl.estrix.shopsync.service.impl.UserLoginServiceExtImpl;


@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final RoleHierarchy roleHierarchy;

    private final AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserRepository userRepository;

    /**
     * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
     * System.out.println("encoder:  " + encoder.encode("test"));
     * @return PasswordEncoder
     */
    @Bean(name = "standardPasswordEncoder")
    public PasswordEncoder standardPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean(name = "userCommandExecutor")
    public UserCommandExecutor userCommandExecutor(){
        return new UserCommandExecutor(userRepository);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserLoginServiceExtImpl(userCommandExecutor());
    }

    @Bean
    public RoleHierarchyVoter roleHierarchyVoter() {
        return new RoleHierarchyVoter(roleHierarchy);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(standardPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/js/**","/images/**","/webjars/**","/webfonts/**","/actuator/**").permitAll()
                .antMatchers(
                        "/",
                        "/version",
                        "/login").permitAll()
                .antMatchers(
                        "/admin/**",
                        "/setting/add/*","/setting/edit/*","/setting/**",
                        "/shop/add/*","/shop/edit/*","/shop/**",
                        "/warehouse/add/*","/warehouse/edit/*","/warehouse/**"
                )
                        .hasAnyRole("ADMIN")
                .antMatchers(
                        "user/edit/*","user/**"
                )
                        .hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .permitAll()
                .and().headers().frameOptions().disable()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


}
