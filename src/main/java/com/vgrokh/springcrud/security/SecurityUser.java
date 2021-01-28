package com.vgrokh.springcrud.security;

import com.vgrokh.springcrud.model.Status;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> grantedAuthorities;
    private boolean isActive;


    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> grantedAuthorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.isActive = isActive;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }


    public static UserDetails fromUserToDetails(com.vgrokh.springcrud.model.User user){
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        return new User(
                user.getUsername(),
                encodedPassword,
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getRole().getAuthorities()
                );
    }
}
