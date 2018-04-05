package com.training.audiomanager.dao;

import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PerformerDao {

    private HashMap<String, Performer> performerHashMap = new HashMap<>();
    private Long lastId = 0L;

    public List<Performer> getAll() {
        return new ArrayList<>(performerHashMap.values());
    }

    public Performer getOrAdd(String performerName) {
        if(!performerHashMap.containsKey(performerName)){
            add(performerName);
        }
        return performerHashMap.get(performerName);
    }

    public void add(String performerName) {
        performerHashMap.putIfAbsent(performerName, new PerformerBuilder().
                buildId(++lastId).buildName(performerName).buildPerformer());
    }

}
