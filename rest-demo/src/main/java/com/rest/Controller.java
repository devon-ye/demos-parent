package com.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/12/4.
 */
@RestController
@RequestMapping("/controller")
public class Controller {

    @RequestMapping("/hello")
    public String getHelloWord(){
        return "hello world";
    }


    @RequestMapping("/downloadExcelTemplate")
    public void downloadExcelTemplate() {

    }


}
