package com.training.audiomanager.service;

import com.training.audiomanager.dao.PerformerDao;
import com.training.audiomanager.entity.Performer;

import java.util.List;

public class PerformerService{

    private PerformerDao performerDao = new PerformerDao();

    public List<Performer> getAll(){
        return performerDao.getAll();
    }

    public Performer getOrAdd(String performerName) {
        return performerDao.getOrAdd(performerName);
    }

    public void add(String performerName){
        performerDao.add(performerName);
    }

}
