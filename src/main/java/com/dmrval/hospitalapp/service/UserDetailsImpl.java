package com.dmrval.hospitalapp.service;

import com.dmrval.hospitalapp.entity.Role;
import com.dmrval.hospitalapp.entity.State;
import com.dmrval.hospitalapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRolename()));
            return grantedAuthorities;
        } else return null;
    }

    @Override
    public String getPassword() {
        if (user != null) {
            return user.getPassword();
        } else return null;
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (user != null) {
            return !user.getStateUser().equals(State.BLOCKED);
        } else return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (user != null) {
            return user.getStateUser().equals(State.ACTIVE);
        }
        return false;
    }

}
