package org.devon.framework.rest.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/12/4.
 */
@RestController
@RequestMapping("/controller")
public class Controller {

    @GetMapping("/hello")
    public String getHelloWord(){
        return "hello world";
    }


    @GetMapping("/downloadExcelTemplate")
    public void downloadExcelTemplate() {

    }


}
