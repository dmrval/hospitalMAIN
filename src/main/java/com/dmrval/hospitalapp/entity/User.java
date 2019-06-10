package com.dmrval.hospitalapp.entity;

import com.dmrval.hospitalapp.service.RoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usrid",nullable = false)
    private int usrid;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "roleid", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state = State.ACTIVE;


    public User() {
    }



    public User(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getUserid() {
        return usrid;
    }

    public void setUserid(int userid) {
        this.usrid = userid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public State getStateUser() {
        return state;
    }

    public void setStateUser(State stateUser) {
        this.state = stateUser;
    }
}