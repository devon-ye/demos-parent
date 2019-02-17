package org.devon.framework.rest.dubbo;

import org.devon.framework.rest.bean.Province;

/**
 * Created by lenovo on 2017/11/26.
 */
public interface IProvinceDubboService {

    Province getProviceName(String provinceName);
}
