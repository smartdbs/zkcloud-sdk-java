package com.zkcloud.api.dbs.common;

import com.google.gson.annotations.Expose;

public class MessagePayload<T> {
    @Expose
    private T params;
    @Expose
    private T results;

    @Expose
    private Integer totalRecords;
    @Expose
    private Integer curPage;
    @Expose
    private Integer totalPages;
    @Expose
    private Integer pageSize;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "MessagePayload{" +
                "params=" + params +
                ", results=" + results +
                ", totalRecords=" + totalRecords +
                ", curPage=" + curPage +
                ", totalPages=" + totalPages +
                ", pageSize=" + pageSize +
                '}';
    }

}
