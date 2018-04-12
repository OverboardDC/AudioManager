package com.training.audiomanager.service;

import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import com.training.audiomanager.service.impl.PerformerServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PerformerServiceImplTest {

    private static PerformerService performerService;
    private static Performer testPerformer;

    @BeforeClass
    public static void init() {
        performerService = new PerformerServiceImpl();
        testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
    }

    @Test
    public void addPerformerTest(){
        int startSize = performerService.getAll().size();
        performerService.add(testPerformer);
        assertTrue(performerService.getAll().size() == startSize + 1);
    }

}
