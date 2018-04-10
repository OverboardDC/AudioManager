package com.training.audiomanager.service;

import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PerformerServiceImplTest {

    private static PerformerServiceImpl performerServiceImpl;
    private static Performer testPerformer;

    @BeforeClass
    public static void init() {
        performerServiceImpl = new PerformerServiceImpl();
        testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
    }

    @Test
    public void addPerformerTest(){
        int startSize = performerServiceImpl.getAll().size();
        performerServiceImpl.add(testPerformer);
        assertTrue(performerServiceImpl.getAll().size() == startSize + 1);
    }

}
