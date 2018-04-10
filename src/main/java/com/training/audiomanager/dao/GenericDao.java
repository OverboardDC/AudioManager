package com.training.audiomanager.dao;

import java.util.List;

public interface GenericDao<T> {

    List<T> getAll();

    void add(T t);

    T get(Long id);

    void edit(T t);

    void remove(Long id);
}
