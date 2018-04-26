package com.training.audiomanager.service;

import com.training.audiomanager.service.util.Pagination;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PaginationTest {


    @Test
    public void testPageLessThanLimit(){
        Pagination pagination = new Pagination();
        pagination.setItemsOnPage(5);
        pagination.setTotalCount(9);
        assertEquals(2, pagination.getPages().size());
    }

    @Test
    public void testPageEqualsLimit(){
        Pagination pagination = new Pagination();
        pagination.setItemsOnPage(5);
        pagination.setTotalCount(10);
        assertEquals(2, pagination.getPages().size());
    }

    @Test
    public void testPageMoreThanLimit(){
        Pagination pagination = new Pagination();
        pagination.setItemsOnPage(5);
        pagination.setTotalCount(11);
        assertEquals(3, pagination.getPages().size());
    }
}
