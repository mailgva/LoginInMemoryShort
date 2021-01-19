package com.gorbatenko.logininmemoryshort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;
import java.util.List;

@Configuration
public class SecurityConfig {

    enum Role implements GrantedAuthority {
        ROLE_READ;

        @Override
        public String getAuthority() {
            return name();
        }
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails u = new User("john", "12345", Collections.singleton(Role.ROLE_READ));
        List<UserDetails> users = List.of(u);
        return new InMemoryUserDetailsManager(users);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}