package com.training.audiomanager.service;

import com.training.audiomanager.dao.PerformerDaoImpl;
import com.training.audiomanager.entity.Performer;

import java.util.List;

public class PerformerServiceImpl implements PerformerService{

    private PerformerDaoImpl performerDaoImpl = new PerformerDaoImpl();

    @Override
    public List<Performer> getAll(){
        return performerDaoImpl.getAll();
    }

    @Override
    public void add(Performer performer) {
        performerDaoImpl.add(performer);
    }

    @Override
    public Performer get(Long id) {
        return performerDaoImpl.get(id);
    }

    @Override
    public Performer get(String name){
        return performerDaoImpl.get(name);
    }

    @Override
    public void edit(Performer performer) {
        performerDaoImpl.edit(performer);
    }

    @Override
    public void remove(Long id) {
        performerDaoImpl.remove(id);
    }

    @Override
    public Performer getOrAdd(String name) {
        return performerDaoImpl.getOrAdd(name);
    }

}
