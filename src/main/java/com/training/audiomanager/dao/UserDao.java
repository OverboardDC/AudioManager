package com.training.audiomanager.dao;

import com.training.audiomanager.entity.User;

public interface UserDao extends GenericDao<User> {

    User login(String username, String password);

    boolean isLoginExists(String username);
}
