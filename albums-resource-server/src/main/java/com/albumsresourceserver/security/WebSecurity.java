package com.albumsresourceserver.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

        http.cors()
            .and()
            .authorizeRequests()
/*            .antMatchers(HttpMethod.GET, "/api/albums/*")
            .authenticated()*/
            .antMatchers(HttpMethod.GET, "/api/albums/**")
            .authenticated()
            .antMatchers(HttpMethod.POST, "/api/albums")
            .hasRole("admin")
            .antMatchers(HttpMethod.PUT, "/api/albums/*")
            .hasRole("admin")
            .antMatchers(HttpMethod.DELETE, "/api/albums/*")
            .hasRole("superadmin")
            .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(authenticationConverter);
    }
}
