package com.training.audiomanager.service;

import com.training.audiomanager.entity.Performer;

public interface PerformerService extends GenericService<Performer> {

    Performer get(String name);

    Performer getOrAdd(String name);
}
