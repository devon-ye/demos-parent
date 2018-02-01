package com.ecas.common.base.controller;

import com.ecas.common.base.service.BaseService;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date ${date} ${time}
 */
public class BaseController <S extends BaseService<T>,T> extends HttpController {

    private S service;
}
