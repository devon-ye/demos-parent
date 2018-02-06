package com.ecas.controller;

import com.ecas.common.base.controller.BaseController;
import com.ecas.entiy.User;
import com.ecas.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2017/12/23.
 */
@Controller
@RequestMapping(value = "/user")
public class UserManagerController extends BaseController<IUserService,User> {

}
