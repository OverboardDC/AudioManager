package com.training.audiomanager.service.impl;

import com.training.audiomanager.dao.UserDao;
import com.training.audiomanager.dao.impl.UserDaoImpl;
import com.training.audiomanager.entity.User;
import com.training.audiomanager.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public void remove(Long id) {
        userDao.remove(id);
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean isLoginExists(String username) {
        return userDao.isLoginExists(username);
    }
}
