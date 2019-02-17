package org.devon.framework.rest.dubbo.impl;

import org.devon.framework.rest.bean.Province;
import org.devon.framework.rest.dubbo.IProvinceDubboService;
import org.springframework.stereotype.Service;


/**
 * Created by lenovo on 2017/11/26.
 */
@Service
public class ProvinceDubboServiceImpl  implements IProvinceDubboService {

    @Override
    public Province getProviceName(String provinceName) {
        return null;
    }
}
