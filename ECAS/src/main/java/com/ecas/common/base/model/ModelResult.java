package com.ecas.common.base.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ModelResult<T> {
    public final static int CODE_200 = 200;
    public final static int CODE_400 = 400;
    public final static int CODE_401 = 401;
    public final static int CODE_406 = 406;
    public final static int CODE_500 = 500;
    public final static int DEFAULT_PAGE_NO = 1;
    public final static int DEFAULT_PAGE_SIZE = 10;
    public final static String SUCCESS = "success";
    public final static String FAIL = "fail";
    private int code;
    private String message;
    private PageResult pageResult;
    private final Map<String,Object> data = new HashMap<>();

    public ModelResult() {
    }

    public ModelResult(int code) {
        this.code = code;
    }

    public ModelResult(int code, String message) {
        this.code = code;
        this.message = message;
    }



    public void setList(List<T> list) {
        data.put("list",list);
    }

    public List<T> getList(){
        return (List<T>) data.get("list");
    }

    public void setEntity(T entity){
        data.put("entity",entity);
    }

    public T getEntity() {
        return (T) data.get("entity");
    }

    public PageResult getPageResult() {
        return pageResult;
    }

    public void setPageResult(PageResult pageResult) {
        this.pageResult = pageResult;
    }
}
