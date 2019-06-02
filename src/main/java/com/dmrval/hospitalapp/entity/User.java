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

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state = State.ACTIVE;


    public User() {
    }

    public User(int usrid, String login, String password, List<Role> roles, State state) {
        this.usrid = usrid;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.state = state;
    }

    public User(String login) {
        this.login = login;
    }

    public User(User r) {
        this.usrid = r.usrid;
        this.login = r.login;
        this.password = r.password;
        this.roles = r.roles;
        this.state = r.state;
    }

    public User(String login, String password, List<Role> roles, State state) {
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.state = state;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    public State getStateUser() {
        return state;
    }

    public void setStateUser(State stateUser) {
        this.state = stateUser;
    }
}