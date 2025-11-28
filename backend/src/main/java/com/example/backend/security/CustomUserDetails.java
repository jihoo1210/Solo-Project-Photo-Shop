package com.example.backend.security;

import com.example.backend.entity.Role;
import com.example.backend.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.backend.entity.Role.ROLE_ADMIN;
import static com.example.backend.entity.Role.ROLE_SELLER;

@RequiredArgsConstructor
@Getter
@ToString
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRole() != null ) {
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
            if(user.getRole().equals(ROLE_SELLER)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
            }
            if(user.getRole().equals(ROLE_ADMIN)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        }
        return authorities;
    }
}
