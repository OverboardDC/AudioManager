package com.training.audiomanager.dao;

import com.training.audiomanager.entity.Performer;

public interface PerformerDao extends GenericDao<Performer>{

    Performer get(String name);

    Performer getOrAdd(String name);
}
