package com.training.audiomanager.service;

import com.training.audiomanager.entity.User;

public interface UserService extends GenericService<User> {

    User login(String username, String password);

    boolean isLoginExists(String username);

}
