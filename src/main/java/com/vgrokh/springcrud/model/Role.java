package com.vgrokh.springcrud.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Authority.DEVELOPERS_WRITE, Authority.DEVELOPERS_READ)),
    USER(Set.of(Authority.DEVELOPERS_READ));
    // MODERATOR(Set.of(Authority.WRITE, Authority.READ)),

    private Set<Authority> permissions;


    Role(Set<Authority> permissions) {
        this.permissions = permissions;
    }

    public Set<Authority> getPermissions() {
        return permissions;
    }


    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permissions -> new SimpleGrantedAuthority((permissions.getAuthority())))
                .collect(Collectors.toSet());
    }
}
