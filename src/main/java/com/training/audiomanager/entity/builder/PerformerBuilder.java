package com.training.audiomanager.entity.builder;

import com.training.audiomanager.entity.Performer;

public class PerformerBuilder {

    private Performer performer;

    public PerformerBuilder() {
        this.performer = new Performer();
    }

    public PerformerBuilder buildId(Long id){
        performer.setId(id);
        return this;
    }

    public PerformerBuilder buildName(String name){
        performer.setName(name);
        return this;
    }

    public Performer buildPerformer(){
        return performer;
    }
}
