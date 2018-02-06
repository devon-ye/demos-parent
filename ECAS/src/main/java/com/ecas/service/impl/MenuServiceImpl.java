package com.ecas.service.impl;

import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.impl.BaseServiceImpl;
import com.ecas.entiy.Menu;
import com.ecas.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/12/28.
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<BaseManager<Menu>, Menu>implements IMenuService {

}
