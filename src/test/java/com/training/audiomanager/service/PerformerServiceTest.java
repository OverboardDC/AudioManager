package com.training.audiomanager.service;

import com.training.audiomanager.entity.Performer;
import com.training.audiomanager.entity.builder.PerformerBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PerformerServiceTest {

    private static PerformerService performerService;
    private static Performer testPerformer;

    @BeforeClass
    public static void init() {
        performerService = new PerformerService();
        testPerformer = new PerformerBuilder().buildId(1L).buildName("Test performer").buildPerformer();
    }

    @After
    public void afterTest() {
        performerService = new PerformerService();
    }

    @Test
    public void addTest() {
        performerService.add(testPerformer.getName());
        assertTrue(performerService.getAll().size() == 1);
    }

    @Test
    public void getTest(){
        performerService.add("test");
        performerService.getOrAdd("test");
        assertTrue(performerService.getAll().size() == 1);
    }

    @Test
    public void addExistingTest(){
        performerService.add("test");
        performerService.getOrAdd("test1");
        assertTrue(performerService.getAll().size() == 2);
    }
}
