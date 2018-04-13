package com.training.audiomanager.entity;

import com.training.audiomanager.util.constants.GlobalConstants;

public class User {

    private Long id;
    private String name;
    private String password;
    private Role role;

    public boolean isAdmin(){
        return role.getId().equals(GlobalConstants.ADMIN_ROLE_ID);
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
