package com.training.audiomanager.service.util;

import com.training.audiomanager.util.PaginationUtil;

import java.util.LinkedList;

public class Pagination {

    private LinkedList<Integer> pages = new LinkedList<>();
    private int itemsOnPage = 5;
    private int page = 1;
    private int totalCount;

    public LinkedList<Integer> getPages(){
        for (int index = 1; index <= PaginationUtil.calculateMaxPage(totalCount, itemsOnPage); index++ ){
            addPage(index);
        }
        return pages;
    }

    private void addPage(int index) {
        if(pages.size() < 5) {
            pages.add(index);
        } else {
            shiftPages(index);
        }
    }

    private void shiftPages(int index) {
        if(page > pages.getLast() / 2 + 1){
            pages.removeFirst();
            pages.add(index);
        }
    }


    public int getItemsOnPage() {
        return itemsOnPage;
    }

    public void setItemsOnPage(int itemsOnPage) {
        this.itemsOnPage = itemsOnPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
