package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
public class User {
    private int usrid;
    private String login;
    private String password;
    private List<Role> roles;
    private State state;

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


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usrid")

    public int getUserid() {
        return usrid;
    }

    public void setUserid(int userid) {
        this.usrid = userid;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "pass")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    public State getStateUser() {
        return state;
    }

    public void setStateUser(State stateUser) {
        this.state = stateUser;
    }
}