package com.ecas.common.base.entiy;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-30 下午11:32
 */

public class PageResult<T> {
    /**
     * 总计条数
     */
    private int totalCount = 0;
    /**
     * 总计页数
     */
    private int totalPage = 0;
    /**
     * 每页条数
     */
    private int pageSize = 0;
    /**
     * 当前页号
     */
    private int pageNo = 1;

    private List<T> items;

    public PageResult(int totalCount, int pageSize, int pageNo, List<T> items) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.items = items;
    }

    public int operateTotalpage() {
        int result = 0;
        if(pageSize != 0) {
            if((result = totalCount/pageSize) != 0 ){
                result++;
            }
        }
        return result;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
