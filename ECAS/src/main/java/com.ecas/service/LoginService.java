package com.ecas.service;

import com.ecas.model.Login;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */
public interface LoginService {

    List<Login> list(Login login);
}
