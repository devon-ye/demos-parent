package com.ecas.entiy;

import javax.servlet.http.HttpServletRequest;

import com.ecas.common.base.model.BaseEntiy;

/**
 * Created by lenovo on 2017/12/9.
 */
public class PageContext extends BaseEntiy {
    private int pagePerRow = 10;
    private boolean pageState = false;

    public static PageContext getContext(HttpServletRequest request,int pagePerRow){
        return null;
    }

    public int getPagePerRow() {
        return pagePerRow;
    }

    public void setPagePerRow(int pagePerRow) {
        this.pagePerRow = pagePerRow;
    }

    public boolean isPageState() {
        return pageState;
    }

    public void setPageState(boolean pageState) {
        this.pageState = pageState;
    }
}
