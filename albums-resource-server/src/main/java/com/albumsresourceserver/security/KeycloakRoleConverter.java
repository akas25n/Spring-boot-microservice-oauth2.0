package com.albumsresourceserver.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmsAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        if (realmsAccess == null || realmsAccess.isEmpty()) {
            return new ArrayList<>();
        }
        Collection<GrantedAuthority> authorities = ((List<String>) realmsAccess.get("roles"))
            .stream().map(role -> "ROLE_" + role)
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
        return authorities;
    }
}
