package com.training.audiomanager.service;

import java.util.List;

public interface GenericService<T> {

    List<T> getAll();

    void add(T t);

    T get(Long id);

    void edit(T t);

    void remove(Long id);

}
