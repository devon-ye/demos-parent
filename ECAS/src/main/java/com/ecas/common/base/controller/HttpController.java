package com.ecas.common.base.controller;

import com.ecas.common.base.model.ModelResult;
import com.ecas.common.base.model.PageResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date ${date} ${time}
 */
public class HttpController {

    protected static  final String RESULT_KEY = "resultKey";
    protected static final  String DEFAULT_CHARSET = "UTF-8";

    protected HttpServletRequest httpServletRequest;
    protected HttpServletResponse httpServletResponse;



    protected final void responseMessage(int code,String message){
        ModelResult modelResult = new ModelResult(code,message);
        httpServletRequest.setAttribute(RESULT_KEY,modelResult);
    }

    protected  final void  resonseEntiy(int code,String message,Object entiy){
        ModelResult modelResult = new ModelResult(code,message);
        modelResult.setEntity(entiy);
        httpServletRequest.setAttribute(RESULT_KEY,modelResult);
    }

    protected  final void  resonseEntiy(Object entiy){
        int code = 0;
        String message = "";
        if(entiy != null) {
          code = ModelResult.CODE_200;
           message = ModelResult.SUCCESS;
       }else {
           code = ModelResult.CODE_500;
           message = ModelResult.FAIL;
       }
        resonseEntiy(code,message,entiy);
    }

    protected  final void  resonseList(List list){
        int code = 0;
        String message = "";
        if(list != null) {
            code = ModelResult.CODE_200;
            message = ModelResult.SUCCESS;
        }else {
            code = ModelResult.CODE_500;
            message = ModelResult.FAIL;
        }
        resonseList(code,message,list);
    }

    protected  final void  resonseList(int code,String message,List list){
        ModelResult modelResult = new ModelResult(code,message);
        modelResult.setList(list);
        httpServletRequest.setAttribute(RESULT_KEY,modelResult);
    }

    protected final void responsePage(int code,String message,int totalCount,int pageSize,int pageNo,List items){
        ModelResult modelResult = new ModelResult(code,message);
        modelResult.setList(items);
        PageResult pageResult = new PageResult(totalCount,pageSize,pageNo,items);
        modelResult.setPageResult(pageResult);
        httpServletRequest.setAttribute(RESULT_KEY,modelResult);
    }

}
