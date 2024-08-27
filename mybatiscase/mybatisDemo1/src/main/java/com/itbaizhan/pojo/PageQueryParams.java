package com.itbaizhan.pojo;

public class PageQueryParams {
    private int startIndex;
    private int pageSize;

    public PageQueryParams(int startIndex, int pageSize) {
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    public PageQueryParams() {
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
