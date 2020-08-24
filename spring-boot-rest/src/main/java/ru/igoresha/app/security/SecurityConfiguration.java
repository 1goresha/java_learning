package ru.igoresha.app.security;

import org.hibernate.event.internal.DefaultPreLoadEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.igoresha.app.models.Role;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//позволяет использовать специальные аннотации для доступа к страничкам в контролере определенным пользователям
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("myUserDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
//                .antMatchers("/").permitAll()                               //не актульно, потому что исопьзовали аннотацию @EnableGlobalMethodSecurity
//                .antMatchers("/signUp").permitAll()
//                .antMatchers("/signIn").permitAll()
//                .antMatchers("/users").hasAuthority(Role.ADMIN.toString())
//                .antMatchers("/products/**").hasAuthority(Role.USER.toString())
//                .antMatchers("/profile").authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn?error")
                .permitAll();
    }
}
