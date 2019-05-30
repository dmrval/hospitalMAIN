package com.dmrval.hospitalapp.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "role")
public class Role {
    private int roleid;
    private String rolename;
    private List<User> users;

    public Role() {
    }


    public Role(String rolename) {
        this.rolename = rolename;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleid")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Column(name = "rolename")
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", users=" + users +
                '}';
    }
}
