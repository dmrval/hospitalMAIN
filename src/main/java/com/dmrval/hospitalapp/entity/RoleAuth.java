package com.dmrval.hospitalapp.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleAuth implements GrantedAuthority {
    PATIENT, DOCTOR, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
