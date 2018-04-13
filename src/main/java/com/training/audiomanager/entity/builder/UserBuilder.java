package com.training.audiomanager.entity.builder;

import com.training.audiomanager.entity.Role;
import com.training.audiomanager.entity.User;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder buildId(Long id){
        user.setId(id);
        return this;
    }

    public UserBuilder buildName(String name){
        user.setName(name);
        return this;
    }

    public UserBuilder buildPassword(String password){
        user.setPassword(password);
        return this;
    }

    public UserBuilder buildRole(Role role){
        user.setRole(role);
        return this;
    }

    public User buildUser(){
        return user;
    }
}
