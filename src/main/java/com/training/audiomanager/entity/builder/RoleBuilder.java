package com.training.audiomanager.entity.builder;

import com.training.audiomanager.entity.Role;

public class RoleBuilder {

    private Role role;

    public RoleBuilder() {
        this.role = new Role();
    }

    public RoleBuilder buildId(Long id){
        role.setId(id);
        return this;
    }

    public RoleBuilder buildName(String name){
        role.setName(name);
        return this;
    }

    public Role buildRole(){
        return role;
    }
}
